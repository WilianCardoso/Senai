package com.wilian.appSmart.controller;

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
        model.addAttribute("id", id);
        model.addAttribute("produto", produto);
        model.addAttribute("preco", preco);
        model.addAttribute("quantidade", quantidade);
        
        // Retorna o nome da página .html a ser renderizada
        return "produto";
    }
}
