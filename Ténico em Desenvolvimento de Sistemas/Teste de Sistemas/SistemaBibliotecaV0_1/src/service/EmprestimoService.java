package service;

import model.Emprestimo;
import model.Livro;
import model.Usuario;
import service.UsuarioService;
import service.MultaService;

import java.util.*;

public class EmprestimoService {
    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private final Map<String, Integer> emprestimosAtivos = new HashMap<>();
    private final int limiteEmprestimos = 5;

    private final MultaService multaService = new MultaService();

    public String realizarEmprestimo(String nomeUsuario, Livro livro, Date dataDevolucao, UsuarioService usuarioService) {
        Usuario usuario = usuarioService.autenticar(nomeUsuario, "");
        if (usuario == null) return "Usuário não encontrado no sistema.";
        if (livro == null) return "Selecione um livro válido.";
        if (livro.isEmprestado()) return "Livro indisponível para empréstimo.";
        if (dataDevolucao.before(new Date())) return "Data de devolução inválida.";
        if (multaService.temMultaEmAberto(nomeUsuario)) return "Usuário impedido de realizar empréstimos devido a multas em aberto.";

        int qtd = emprestimosAtivos.getOrDefault(nomeUsuario, 0);
        if (qtd >= limiteEmprestimos) return "Limite de empréstimos atingido.";

        livro.setEmprestado(true);
        emprestimos.add(new Emprestimo(nomeUsuario, livro, new Date(), dataDevolucao));
        emprestimosAtivos.put(nomeUsuario, qtd + 1);
        return "Empréstimo realizado com sucesso.";
    }

    public List<Emprestimo> listarEmprestimosPorUsuario(String nomeUsuario) {
        List<Emprestimo> lista = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {
                lista.add(e);
            }
        }
        return lista;
    }

    public void devolverLivro(Emprestimo e) {
        e.setDevolvido(true);
        e.getLivro().setEmprestado(false);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimos;
    }
}