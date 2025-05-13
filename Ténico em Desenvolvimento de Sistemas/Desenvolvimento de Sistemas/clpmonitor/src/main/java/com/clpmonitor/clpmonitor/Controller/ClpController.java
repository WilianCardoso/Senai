//------------------------------------------------------------------------------------------
// Atualização de Eventos do Backend para o Frontend utilizando SSE - Server Sent Events
// Curso Técnico em Desenvolvimento de Sistemas - SENAI Timbó -SC
// UC: Desenvolvimento de Sistemas
// Docente: Gerson Trindade         SET-2024
//------------------------------------------------------------------------------------------
package com.clpmonitor.clpmonitor.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.clpmonitor.clpmonitor.Model.TagWriteRequest;
import com.clpmonitor.clpmonitor.PLC.PlcConnector;
import com.clpmonitor.clpmonitor.Service.ClpSimulatorService;
import com.clpmonitor.clpmonitor.Util.TagValueParser;
import com.clpmonitor.clpmonitor.Model.Tag;

@Controller
public class ClpController {

    // Injeta automaticamente uma instância da classe ClpSimulatorService.
    // Essa classe é responsável por simular os dados dos CLPs e gerenciar
    // os eventos SSE que serão enviados ao frontend.
    @Autowired
    private ClpSimulatorService simulatorService;

    // Mapeia a URL raiz (http://localhost:8080/) para o método index().
    // Retorna a view index.html, localizada em
    // src/main/resources/templates/index.html (Thymeleaf).
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tag", new TagWriteRequest());
        return "index";
    }

    // Rota "/clp-data-stream" — Comunicação via SSE (Server-Sent Events)
    // Essa rota é chamada no JavaScript pelo EventSource:
    @GetMapping("/clp-data-stream")

    // Retorna um objeto SseEmitter, que é a classe do Spring para enviar
    // dados do servidor para o cliente continuamente usando Server-Sent Events.
    public SseEmitter streamClpData() {
        // Esse método delega a lógica para simulatorService.subscribe() que:
        // Cria o SseEmitter.
        // Armazena ele numa lista de ouvintes (clientes conectados).
        // Inicia o envio periódico dos dados simulados
        return simulatorService.subscribe();
    }

   @PostMapping("/write-tag")
public ResponseEntity<?> writeTag(@ModelAttribute TagWriteRequest request, Model model) {
    try {
        Object typedValue = TagValueParser.parseValue(request.getValue(), request.getType());
        
        System.out.println("\nDados recebidos para escrita:");
        System.out.println("IP: " + request.getIp());
        System.out.println("Porta: " + request.getPort());
        System.out.println("DB: " + request.getDb());
        System.out.println("Offset: " + request.getOffset());
        System.out.println("Tipo: " + request.getType());
        System.out.println("Valor convertido: " + typedValue);

        // Simulação de escrita - substitua pela lógica real
        boolean writeSuccess = true; // simulatorService.writeToPlc(request);
        
        if (writeSuccess) {
            return ResponseEntity.ok().body(Map.of(
                "message", "Valor escrito com sucesso!",
                "status", "success"
            ));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Falha na escrita no CLP"));
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("error", "Erro: " + e.getMessage()));
    }
}

    @GetMapping("/fragmento-formulario")
    public String carregarFragmentoFormulario(Model model) {
        model.addAttribute("tag", new TagWriteRequest()); // substitua pelo seu DTO real
        return "fragments/formulario :: clp-write-fragment";
    }

    @PostMapping("/update-stock")
    public String updateStock() {
        simulatorService.updateStock();
        return "redirect:/fragmento-formulario";
    }

    @PostMapping("/update-expedition")
    public String updateExpedition() {
        simulatorService.updateExpedition();
        return "redirect:/fragmento-formulario";
    }

    @PostMapping("/update")
    public String update() {
        simulatorService.startSimulation();
        return "redirect:/fragmento-formulario";
    }

}
