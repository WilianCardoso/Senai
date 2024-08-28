package com.garagem.restapi.cor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Cor {
 @Id // indica que o campo abaixo é o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que o campo será autoincrementado
    private int id;

    @Column(nullable = false)//definimos que o valor não pode ser nulo
    private String cor;
    
    @Column(nullable = false)
    private int satatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getSatatus() {
        return satatus;
    }

    public void setSatatus(int satatus) {
        this.satatus = satatus;
    }
}
