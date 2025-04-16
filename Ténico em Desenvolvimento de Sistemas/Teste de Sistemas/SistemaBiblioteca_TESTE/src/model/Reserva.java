package model;

public class Reserva {
    private String nomeUsuario;
    private Livro livro;

    public Reserva(String nomeUsuario, Livro livro) {
        this.nomeUsuario = nomeUsuario;
        this.livro = livro;
    }

    public String getNomeUsuario() { return nomeUsuario; }
    public Livro getLivro() { return livro; }
}