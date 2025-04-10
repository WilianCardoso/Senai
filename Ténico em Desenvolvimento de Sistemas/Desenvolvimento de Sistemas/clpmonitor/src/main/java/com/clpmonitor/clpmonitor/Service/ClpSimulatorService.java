//------------------------------------------------------------------------------------------
// Atualização de Eventos do Backend para o Frontend utilizando SSE - Server Sent Events
// Curso Técnico em Desenvolvimento de Sistemas - SENAI Timbó -SC
// UC: Desenvolvimento de Sistemas
// Docente: Gerson Trindade         SET-2024
//------------------------------------------------------------------------------------------
package com.clpmonitor.clpmonitor.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.PLC.PlcConnector;
import com.clpmonitor.clpmonitor.Model.ClpData;

import jakarta.annotation.PostConstruct;

// Define que esta classe é um componente de serviço do Spring (fica disponível para injeção com @Autowired).
// Contém a lógica de negócio: neste caso, a simulação de dados dos CLPs e envio via SSE.
@Service
public class ClpSimulatorService {

    // emitters – Lista de clientes conectados via SSE
    // Guarda todos os clientes que estão conectados e escutando eventos via SSE.
    // CopyOnWriteArrayList é usada para permitir acesso concorrente com
    // segurança (vários threads atualizando a lista).
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
    private PlcConnector plcEstDb9;
    private byte[] indexColorEst = new byte[28];

    // executor – Agendamento das tarefas de simulações
    // Cria uma pool de threads agendadas (com 2 threads).
    // É usada para executar tarefas repetidamente com um intervalo fixo (ex: a cada
    // 1 segundo).
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    // @PostConstruct – Inicialização automática
    @PostConstruct
    // Esse método é chamado automaticamente após a construção do bean.
    // Define os dois agendamentos de envio de dados simulados:
    public void startSimulation() {
        // Agendamento separado para CLP 1 (800ms)
        executor.scheduleAtFixedRate(this::sendClp1Update, 0, 3800, TimeUnit.MILLISECONDS);

        // Agendamento para CLPs 2 a 4 (1 segundo)
        executor.scheduleAtFixedRate(this::sendClp2to4Updates, 0, 3, TimeUnit.SECONDS);
    }

    // subscribe() – Adiciona cliente à lista de ouvintes SSE
    // Esse método é chamado quando o frontend conecta-se à URL /clp-data-stream.
    public SseEmitter subscribe() {
        // Cria um novo SseEmitter com timeout infinito (0L).
        SseEmitter emitter = new SseEmitter(0L);

        // Adiciona esse emitter à lista emitters.
        emitters.add(emitter);

        // Remove o cliente se ele desconectar ou der timeout.
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));

        return emitter;
    }

    // sendClp1Update() – Gera 28 bytes (valores de 0 a 3) para o CLP 1
    private void sendClp1Update() {
        PlcConnector plc = null;
        try {
            // 1. Estabelece conexão
            plc = new PlcConnector("10.74.241.10", 102);
            plc.connect();
            
            // 2. Leitura dos dados do CLP com tratamento de timeout
            byte[] dadosPlc = plc.readBlock(9, 68, 28);
            
            // 3. Processamento dos dados
            List<Integer> byteArray = new ArrayList<>();
            for (int i = 0; i < 28; i++) {
                byteArray.add(dadosPlc[i] & 0x03); // Garante valores entre 0-3
            }
            
            // 4. Envio dos dados
            sendToEmitters("clp1-data", new ClpData(1, byteArray));
            
        } catch (Exception e) {
            // Envia mensagem de erro via SSE
            sendToEmitters("clp-error", new ClpData(0, "Erro na conexão com CLP: " + e.getMessage()));
        } finally {
            // 5. Fechamento seguro da conexão
            if (plc != null) {
                try {
                    plc.disconnect();
                } catch (Exception e) {
                    System.err.println("Erro ao desconectar: " + e.getMessage());
                }
            }
        }
    }

    // sendClp2to4Updates() – Gera valores inteiros simples
    // Simula os valores para os CLPs 2, 3 e 4 com números aleatórios de 0 a 99.
    private void sendClp2to4Updates() {
        Random rand = new Random();

        sendToEmitters("clp2-data", new ClpData(2, rand.nextInt(100)));
        sendToEmitters("clp3-data", new ClpData(3, rand.nextInt(100)));
        sendToEmitters("clp4-data", new ClpData(4, rand.nextInt(100)));
    }

    // sendToEmitters() – Envia um evento SSE para todos os clientes
    private void sendToEmitters(String eventName, ClpData clpData) {
        // Percorre todos os SseEmitters conectados.
        for (SseEmitter emitter : emitters) {
            try {
                // Envia um evento com:
                // eventName → nome do evento no frontend (ex: clp1-data, clp2-data, etc).
                // data(clpData) → dados a serem enviados (convertidos para JSON
                // automaticamente).
                emitter.send(SseEmitter.event().name(eventName).data(clpData));
            } catch (IOException e) {
                // Se algum cliente tiver erro de conexão, ele é removido da lista.
                emitters.remove(emitter);
            }
        }
    }

}
