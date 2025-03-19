package com.tecdes.appcad.service;

import com.tecdes.appcad.model.Produto;
import com.tecdes.appcad.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void salvarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public void deletarPorId(Long id) {
        produtoRepository.deleteById(id);
    }

    public void atualizarProduto(Produto produto, MultipartFile imagem) throws IOException {
        if (!imagem.isEmpty()) {
            produto.setImagemBytes(imagem.getBytes());
        }
        produtoRepository.save(produto);
    }
}