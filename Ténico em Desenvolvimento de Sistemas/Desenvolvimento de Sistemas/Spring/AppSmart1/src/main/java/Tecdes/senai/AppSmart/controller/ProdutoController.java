package Tecdes.senai.AppSmart.controller;

import Tecdes.senai.AppSmart.model.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    public ProdutoController() {
        carregarProdutos();
    }

    @GetMapping("/tabela")
    public String lerArquivosProdutos(Model model) {
        carregarProdutos();
        model.addAttribute("produtos", produtos);
        model.addAttribute("produto", new Produto());
        return "tabela";
    }

    @PostMapping("/addProduto")
    public String adicionarProduto(@ModelAttribute Produto produto) {
        int index = encontrarProdutoPorCodigo(produto.getCodigo());
        if (index >= 0) {
            produtos.set(index, produto);
        } else {
            produtos.add(produto);
        }
        salvarProdutos();
        return "redirect:/tabela";
    }

    @GetMapping("/editar/{codigo}")
    public String editarProduto(@PathVariable String codigo, Model model) {
        Produto produto = produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(new Produto());
        model.addAttribute("produto", produto);
        model.addAttribute("produtos", produtos);
        return "tabela";
    }

    @PostMapping("/atualizarProduto")
    public String atualizarProduto(@ModelAttribute Produto produto) {
        produtos.removeIf(p -> p.getCodigo().equals(produto.getCodigo()));
        produtos.add(produto);
        return "redirect:/tabela";
    }

    @GetMapping("/deletar/{codigo}")
    public String deletarProduto(@PathVariable String codigo) {
        produtos.removeIf(p -> p.getCodigo().equals(codigo));
        salvarProdutos();
        return "redirect:/tabela";
    }

    // -----------------------------------------------------------------------------

    private int encontrarProdutoPorCodigo(String codigo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    private void salvarProdutos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("produtos.txt"))) {
            for (Produto p : produtos) {
                bw.write(p.getCodigo() + ";" + p.getDescricao() + ";" + p.getQtd() + ";" + p.getPreco());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarProdutos() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("produtos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    Produto p = new Produto(dados[0], dados[1], Integer.parseInt(dados[2]),
                            Double.parseDouble(dados[3]));
                    produtos.add(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}