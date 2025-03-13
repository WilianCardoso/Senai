package Tecdes.senai.AppSmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
    
    @GetMapping("/produto")
    public String mostrarProduto(Model model) {
        // Variáveis que serão enviadas para o front-end
        int id = 12;
        String produto = "Camisa Polo";
        double preco = 149.99;
        int quantidade = 15;

        //adiciona as variáveis ao modelo
        model.addAllAttribute("id", id);
        model.addAllAttribute("produto", produto);
        model.addAllAttribute("preco", preco);
        model.addAllAttribute("quantidade", quantidade);
        
        // Retorna o nome da página .html a ser renderizada
        return "produto";
    }
}
