package com.garagem.restapi.car.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garagem.restapi.car.entities.Car;

public interface RepositoryCar extends JpaRepository<Car, Integer>{

}
