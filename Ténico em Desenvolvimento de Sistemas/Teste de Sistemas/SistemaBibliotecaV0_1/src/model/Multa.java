package model;

import java.util.Date;

public class Multa {
    private String nomeUsuario;
    private double valor;
    private Date dataGerada;
    private boolean paga;

    public Multa(String nomeUsuario, double valor) {
        this.nomeUsuario = nomeUsuario;
        this.valor = valor;
        this.dataGerada = new Date();
        this.paga = false;
    }

    public String getNomeUsuario() { return nomeUsuario; }
    public double getValor() { return valor; }
    public Date getDataGerada() { return dataGerada; }
    public boolean isPaga() { return paga; }
    public void setPaga(boolean paga) { this.paga = paga; }
}