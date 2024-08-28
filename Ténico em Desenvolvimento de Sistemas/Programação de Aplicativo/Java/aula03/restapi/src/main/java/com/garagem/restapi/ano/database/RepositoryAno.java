package com.garagem.restapi.ano.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garagem.restapi.ano.entities.Ano;

public interface RepositoryAno extends JpaRepository<Ano, Integer>{

}
