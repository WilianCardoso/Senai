package model;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private String categoria;
    private String localEstante;
    private boolean emprestado;
    private boolean reservado; // Adicionado para controle de reservas

    public Livro(String titulo, String autor, String editora, String isbn, String categoria, String localEstante) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.categoria = categoria;
        this.localEstante = localEstante;
        this.emprestado = false;
        this.reservado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getEditora() { return editora; }
    public String getIsbn() { return isbn; }
    public String getCategoria() { return categoria; }
    public String getLocalEstante() { return localEstante; }
    public boolean isEmprestado() { return emprestado; }
    public boolean isReservado() { return reservado; }

    public void setEmprestado(boolean valor) { this.emprestado = valor; }
    public void setReservado(boolean valor) { this.reservado = valor; }
    public void setLocalEstante(String local) { this.localEstante = local; }
}