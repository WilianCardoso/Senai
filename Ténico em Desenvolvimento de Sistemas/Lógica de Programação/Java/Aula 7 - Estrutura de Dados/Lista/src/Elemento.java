/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wilian_g_cardoso
 */
public class Elemento {
    //O que o elemento tem de inforcao
    private String valor;

    public Elemento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
    private Elemento proximo;
}
