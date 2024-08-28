package com.garagem.restapi.cor.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garagem.restapi.cor.entities.Cor;

public interface RepositoryCor extends JpaRepository<Cor, Integer>{

}