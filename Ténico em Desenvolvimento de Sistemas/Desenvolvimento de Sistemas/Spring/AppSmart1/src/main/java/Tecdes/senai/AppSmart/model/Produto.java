package Tecdes.senai.AppSmart.model;

public class Produto{
    private String codigo;
    private String descricao;
    private int qtd;
    private double preco;


       // Construtor correto
       public Produto(String codigo, String descricao, int qtd, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtd = qtd;
        this.preco = preco;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


}