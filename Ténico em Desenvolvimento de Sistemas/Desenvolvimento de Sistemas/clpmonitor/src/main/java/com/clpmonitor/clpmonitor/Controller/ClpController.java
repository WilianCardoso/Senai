package com.clpmonitor.clpmonitor.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.clpmonitor.clpmonitor.Model.TagWriteRequest;
import com.clpmonitor.clpmonitor.PLC.PlcConnector;
import com.clpmonitor.clpmonitor.Service.ClpSimulatorService;
import com.clpmonitor.clpmonitor.Util.TagValueParser;
import com.clpmonitor.clpmonitor.Service.PedidoTesteService;

@Controller
public class ClpController {

    @Autowired
    private ClpSimulatorService simulatorService;

    @Autowired
    private PedidoTesteService pedidoTesteService;
    
    private final PlcConnector plcConnector;

    public ClpController(PlcConnector plcConnector, ClpSimulatorService simulatorService) {
        this.plcConnector = plcConnector;
        this.simulatorService = simulatorService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tag", new TagWriteRequest());
        return "index";
    }

    @GetMapping("/clp-data-stream")
    public SseEmitter streamClpData() {
        return simulatorService.subscribe();
    }

    @PostMapping("/write-tag")
    public ResponseEntity<?> writeTag(@ModelAttribute TagWriteRequest request) {
        try {
            PlcConnector plc = new PlcConnector(request.getIp(), request.getPort());
            plc.connect();

            Object typedValue = TagValueParser.parseValue(request.getValue(), request.getType());

            boolean writeSuccess = false;

            switch (request.getType().toUpperCase()) {
                case "STRING":
                    writeSuccess = plc.writeString(request.getDb(), request.getOffset(),
                            request.getSize(), (String) typedValue);
                    break;
                case "BLOCK":
                    writeSuccess = plc.writeBlock(request.getDb(), request.getOffset(),
                            request.getSize(), (byte[]) typedValue);
                    break;
                case "FLOAT":
                    writeSuccess = plc.writeFloat(request.getDb(), request.getOffset(),
                            (Float) typedValue);
                    break;
                case "INTEGER":
                    writeSuccess = plc.writeInt(request.getDb(), request.getOffset(),
                            (Integer) typedValue);
                    break;
                case "BYTE":
                    writeSuccess = plc.writeByte(request.getDb(), request.getOffset(),
                            (Byte) typedValue);
                    break;
                case "BIT":
                    writeSuccess = plc.writeBit(request.getDb(), request.getOffset(),
                            request.getBitNumber(), (Boolean) typedValue);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo não suportado: " + request.getType());
            }

            plc.disconnect();

            if (writeSuccess) {
                return ResponseEntity.ok().body(Map.of(
                        "message", "Valor escrito com sucesso!",
                        "status", "success"));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Map.of("error", "Falha na escrita no CLP"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Erro: " + e.getMessage()));
        }
    }

    @GetMapping("/estoque")
    public ResponseEntity<List<Integer>> getEstoque() {
        try {
            List<Integer> estoque = simulatorService.getEstoque();
            return ResponseEntity.ok(estoque);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @PutMapping("/estoque/{posicao}")
    public ResponseEntity<Void> atualizarPosicaoEstoque(
            @PathVariable int posicao,
            @RequestParam int cor) {
        
        if (posicao < 1 || posicao > 28) {
            return ResponseEntity.badRequest().build();
        }
        
        if (cor < 0 || cor > 3) {
            return ResponseEntity.badRequest().build();
        }
        
        try {
            simulatorService.atualizarPosicaoEstoque(posicao - 1, cor);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @DeleteMapping("/estoque/{posicao}")
    public ResponseEntity<Void> limparPosicaoEstoque(@PathVariable int posicao) {
        try {
            simulatorService.atualizarPosicaoEstoque(posicao - 1, 0);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @PutMapping("/estoque")
    public ResponseEntity<Void> atualizarEstoqueCompleto(@RequestBody List<Integer> estoque) {
        if (estoque == null || estoque.size() != 28) {
            return ResponseEntity.badRequest().build();
        }
        
        try {
            simulatorService.atualizarEstoqueCompleto(estoque);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/fragmento-formulario")
    public String carregarFragmentoFormulario(Model model) {
        model.addAttribute("tag", new TagWriteRequest());
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

    @PostMapping("/pedidoTeste")
    public String peditoTeste() {
        pedidoTesteService.enviarPedidoTeste();
        return "redirect:/store";
    }

    @GetMapping("/store")
    public String exibirStore() {
        return "store"; 
    }
}