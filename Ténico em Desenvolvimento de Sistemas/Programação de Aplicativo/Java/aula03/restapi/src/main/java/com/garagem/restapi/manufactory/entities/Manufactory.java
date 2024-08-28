package com.garagem.restapi.manufactory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Manufactory {
 @Id // indica que o campo abaixo é o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que o campo será autoincrementado
    private int id;

    @Column(nullable = false)//definimos que o valor não pode ser nulo
    private String fabricante;
    
    @Column(nullable = false)
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
