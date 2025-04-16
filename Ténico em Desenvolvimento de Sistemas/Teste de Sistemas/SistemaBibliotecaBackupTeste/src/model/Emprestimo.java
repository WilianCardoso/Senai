package model;

import model.Livro;
import java.util.Date;

public class Emprestimo {
    private String nomeUsuario;
    private Livro livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean devolvido;

    public Emprestimo(String nomeUsuario, Livro livro, Date dataEmprestimo, Date dataDevolucao) {
        this.nomeUsuario = nomeUsuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = false;
    }

    public String getNomeUsuario() { return nomeUsuario; }
    public Livro getLivro() { return livro; }
    public Date getDataEmprestimo() { return dataEmprestimo; }
    public Date getDataDevolucao() { return dataDevolucao; }
    public boolean isDevolvido() { return devolvido; }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
} 