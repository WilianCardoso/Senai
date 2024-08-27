package com.garagem.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.garagem.restapi.database.RepositoryCar;
import com.garagem.restapi.entities.Car;

public class CarREST {
    @Autowired // cria objeto e injeta dentro do repository para cuidar do ciclo   
    private RepositoryCar repository;

    //definir os metodos do CRUD
    public List<Car> listar(){
        return repository.findAll();
    }

    public void salvar(Car id){
        repository.save(id);
    }
    public void alterar(Car id){
        if (id.getId() > 0)
        repository.save(id);
    }
    public void excluir(Car id){
        repository.delete(id);
    }
    
}
