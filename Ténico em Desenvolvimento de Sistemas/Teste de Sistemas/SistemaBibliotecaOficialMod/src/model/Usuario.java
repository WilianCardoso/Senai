package model;

public class Usuario {
    private String nome;
    private String senha;
    private String tipo; // bibliotecario, professor, aluno, visitante

    public Usuario(String nome, String senha, String tipo) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }
} 