package Tela;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author cardo
 */
public class Carro {

    //Atributos
    private String cor, desc;
    private int pot, cod;

    // Construtor padrão vazio
    public Carro() {

    }
    
    //Construtor que receber todos os atributos do carro
    public Carro(Integer cod, String desc, Integer pot, String cor) {
        this.cod = cod;
        this.desc = desc;
        this.pot = pot;
        this.cor = cor;
    }
    
    //Construtor que receber todos os atributos do carro exceto o código
    public Carro(String desc, Integer pot, String cor) {
        this.desc = desc;
        this.pot = pot;
        this.cor = cor;
    }

    // Métodos de acesso getters e setters
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

}
