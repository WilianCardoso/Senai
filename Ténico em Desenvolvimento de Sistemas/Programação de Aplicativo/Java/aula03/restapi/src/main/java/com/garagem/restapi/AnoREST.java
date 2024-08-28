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

import com.garagem.restapi.ano.database.RepositoryAno;
import com.garagem.restapi.ano.entities.Ano;

@RestController
@RequestMapping("/ano")
public class AnoREST {
    @Autowired // cria objeto e injeta dentro do repository para cuidar do ciclo   
    private RepositoryAno repository;

    //definir os metodos do CRUD
    @GetMapping // parametrizar para consulta
    public List<Ano> listar(){
        return repository.findAll();
    }

    @PostMapping //parametrizar para salvar e converter em JSON
    public void salvar(@RequestBody Ano id){
        repository.save(id);
    }

    @PutMapping 
    public void alterar(@RequestBody Ano id){
        if (id.getId() > 0)
        repository.save(id);
    }

    @DeleteMapping
    public void excluir(@RequestBody Ano id){
        repository.delete(id);
    }
    
}
