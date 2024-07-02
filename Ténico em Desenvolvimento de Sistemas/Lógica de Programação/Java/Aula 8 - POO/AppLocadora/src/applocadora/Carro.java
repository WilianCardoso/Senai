/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applocadora;

/**
 *
 * @author wilian_g_cardoso
 */
public class Carro {

    //Definiçao dos atributos de classe
    private String modelo;
    private String cor;
    private String motor;
    private int km;
    private int tpCombustivel;
    public float qtdCombustivel;
    private boolean parado;
    private boolean desligado;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getTpCombustivel() {
        return tpCombustivel;
    }

    public void setTpCombustivel(int tpCombustivel) {
        this.tpCombustivel = tpCombustivel;
    }

    // método construtor
    public Carro(String modelo, String cor){
        this.modelo = modelo;
        this.cor = cor;
        this.parado = true;
        this.desligado = true;
        this.km = 0;
        
    }
    
    //Definição dos métodos da classe
    public void avancar(int km) {
        if(desligado){
            System.out.println("Carro está ligado");
            desligado = false;
        }
        else{
            System.out.println("Carro está andando");
            acelerar(5);
            parado = false;
        }
    }

    public void voltar() {

    }

    public void acelerar(int km) {
        System.out.println("Carro acelerando.");
        // carro acelerando
        this.km += km;
    }

    public void parar() {
        if (!parado) {
            parado = true;
        } else {
            // O carro já está parado
            System.out.println("Carro ja esta parado....");

        }
    }

    public void ligar() {
        if (desligado) {
            desligado = false;
        } else {
            // O carro já está ligado
            System.out.println("Carro ja esta ligado...");

        }
    }

    public void desligar() {
        if (!desligado) {
            desligado = true;
        } else {
            // O carro já está desligado
        }
    }

    public void printStatus() {
        System.out.println("Modelo....: " + this.modelo);
        System.out.println("Cor.......: " + this.cor);
        System.out.println("Desligado....: " + this.desligado);
        System.out.println("Parado....: " + this.parado);
        System.out.println("Quilometragem........: " + this.km);
    }
}
