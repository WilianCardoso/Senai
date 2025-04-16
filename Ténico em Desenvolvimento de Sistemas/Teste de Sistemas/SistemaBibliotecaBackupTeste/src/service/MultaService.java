package service;

import model.Multa;
import model.Emprestimo;

import java.util.*;

public class MultaService {
    private final List<Multa> multas = new ArrayList<>();
    private final double VALOR_DIA_ATRASO = 2.50;

    public void verificarAtrasos(List<Emprestimo> emprestimos) {
        Date hoje = new Date();
        for (Emprestimo e : emprestimos) {
            if (!e.isDevolvido() && e.getDataDevolucao().before(hoje)) {
                long dias = (hoje.getTime() - e.getDataDevolucao().getTime()) / (1000 * 60 * 60 * 24);
                double valor = dias * VALOR_DIA_ATRASO;
                multas.add(new Multa(e.getNomeUsuario(), valor));
            }
        }
    }

    public List<Multa> listarMultasPorUsuario(String nome) {
        List<Multa> lista = new ArrayList<>();
        for (Multa m : multas) {
            if (m.getNomeUsuario().equalsIgnoreCase(nome)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public boolean temMultaEmAberto(String nome) {
        for (Multa m : multas) {
            if (m.getNomeUsuario().equalsIgnoreCase(nome) && !m.isPaga()) {
                return true;
            }
        }
        return false;
    }

    public boolean pagarMultasDoUsuario(String nome) {
        boolean pagouAlguma = false;
        for (Multa m : multas) {
            if (m.getNomeUsuario().equalsIgnoreCase(nome) && !m.isPaga()) {
                m.setPaga(true);
                pagouAlguma = true;
            }
        }
        return pagouAlguma;
    }
}