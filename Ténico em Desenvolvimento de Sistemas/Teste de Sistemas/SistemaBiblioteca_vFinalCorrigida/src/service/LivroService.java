package service;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private final List<Livro> livros = new ArrayList<>();

    public LivroService() {
        livros.add(new Livro("Dom Casmurro", "Machado de Assis", "Editora A", "1234567890", "Romance", "Estante A1"));
        livros.add(new Livro("A Revolução dos Bichos", "George Orwell", "Editora B", "2345678901", "Fábula Política", "Estante B2"));
        livros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Editora C", "3456789012", "Ficção", "Estante C3"));
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        List<Livro> resultados = new ArrayList<>();
        for (Livro l : livros) {
            if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(l);
            }
        }
        return resultados;
    }

    public void excluirLivro(Livro livro) {
        livros.remove(livro);
    }
}
