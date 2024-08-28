package com.garagem.restapi.manufactory.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garagem.restapi.manufactory.entities.Manufactory;

public interface RepositoryManufactory extends JpaRepository<Manufactory, Integer>{

}