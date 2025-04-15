//------------------------------------------------------------------------------------------
// Atualização de Eventos do Backend para o Frontend utilizando SSE - Server Sent Events
// Curso Técnico em Desenvolvimento de Sistemas - SENAI Timbó -SC
// UC: Desenvolvimento de Sistemas
// Docente: Gerson Trindade         SET-2024
//------------------------------------------------------------------------------------------
package com.clpmonitor.clpmonitor.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.clpmonitor.clpmonitor.Model.ClpData;
import com.clpmonitor.clpmonitor.PLC.PlcConnector;

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
    private PlcConnector plcConnector;
    private boolean connectionActive = false;


    // executor – Agendamento das tarefas de simulações
    // Cria uma pool de threads agendadas (com 2 threads).
    // É usada para executar tarefas repetidamente com um intervalo fixo (ex: a cada
    // 1 segundo).
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

 /*   // @PostConstruct – Inicialização automática
    @PostConstruct
    // Esse método é chamado automaticamente após a construção do bean.
    // Define os dois agendamentos de envio de dados simulados:
    public void startSimulation() {
        // Agendamento separado para CLP 1 (800ms)
        executor.scheduleAtFixedRate(this::sendClp1Update, 0, 3800, TimeUnit.MILLISECONDS);

        // Agendamento para CLPs 2 a 4 (1 segundo)
        executor.scheduleAtFixedRate(this::sendClp2to4Updates, 0, 3, TimeUnit.SECONDS);
    } */

    private synchronized void initializePlcConnection() {
        if (!connectionActive) {
            try {
                plcConnector = new PlcConnector("10.74.241.10", 102);
                plcConnector.connect();
                connectionActive = true;
                System.out.println("Conexão PLC estabelecida com sucesso");
            } catch (Exception e) {
                connectionActive = false;
                System.err.println("Falha ao conectar ao PLC: " + e.getMessage());
            }
        }
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
    public void readClp1Data() {
        PlcConnector plc = null;
        try {
            plc = new PlcConnector("10.74.241.10", 102);
            plc.connect();
            byte[] dadosPlc = plc.readBlock(9, 68, 28);
            
            List<Integer> byteArray = new ArrayList<>();
            for (int i = 0; i < 28; i++) {
                byteArray.add(dadosPlc[i] & 0x03);
            }
            
            sendToEmitters("clp1-data", new ClpData(1, byteArray));
        } catch (Exception e) {
            sendToEmitters("clp-error", new ClpData(0, "Erro na conexão com CLP: " + e.getMessage()));
        } finally {
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
    public void readExpedicaoData() {
        if (!connectionActive) {
            initializePlcConnection();
            if (!connectionActive) {
                sendToEmitters("clp-error", new ClpData(0, "Sem conexão com o CLP"));
                return;
            }
        }
    
        try {
            byte[] dadosExpedicao = plcConnector.readBlock(9, 76, 12);
            int[] valores = new int[12];
            
            // Inicializa com valores padrão 0
            Arrays.fill(valores, 0);
            
            if (dadosExpedicao != null) {
                for (int i = 0; i < Math.min(12, dadosExpedicao.length); i++) {
                    valores[i] = dadosExpedicao[i] & 0xFF;
                }
            }
            
            sendToEmitters("expedicao-data", new ClpData(5, valores));
        } catch (Exception e) {
            // Envia array de zeros em caso de erro
            sendToEmitters("expedicao-data", new ClpData(5, new int[12]));
            System.err.println("Erro na leitura da expedição: " + e.getMessage());
        }
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
