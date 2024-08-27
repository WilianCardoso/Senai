package com.garagem.restapi.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garagem.restapi.entities.Car;

public interface RepositoryCar extends JpaRepository<Car, Integer>{

}
