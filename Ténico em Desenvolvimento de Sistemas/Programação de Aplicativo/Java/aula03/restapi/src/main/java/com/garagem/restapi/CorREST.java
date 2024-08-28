package com.garagem.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garagem.restapi.cor.database.RepositoryCor;
import com.garagem.restapi.cor.entities.Cor;

@RestController
@RequestMapping("/cor")
public class CorREST {
    @Autowired // cria objeto e injeta dentro do repository para cuidar do ciclo   
    private RepositoryCor repository;

    //definir os metodos do CRUD
    @GetMapping // parametrizar para consulta
    public List<Cor> listar(){
        return repository.findAll();
    }

    @PostMapping //parametrizar para salvar e converter em JSON
    public void salvar(@RequestBody Cor id){
        repository.save(id);
    }

    @PutMapping 
    public void alterar(@RequestBody Cor id){
        if (id.getId() > 0)
        repository.save(id);
    }

    @DeleteMapping
    public void excluir(@RequestBody Cor id){
        repository.delete(id);
    }
    
}
