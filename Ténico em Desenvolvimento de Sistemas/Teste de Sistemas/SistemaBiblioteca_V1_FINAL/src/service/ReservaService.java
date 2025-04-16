package service;

import model.Reserva;
import model.Livro;

import java.util.*;

public class ReservaService {
    private final Map<Livro, Queue<Reserva>> filaReservas = new HashMap<>();

    public String reservarLivro(String nomeUsuario, Livro livro) {
        if (!livro.isEmprestado()) {
            return "Livro está disponível. Não é necessário reservar.";
        }

        filaReservas.putIfAbsent(livro, new LinkedList<>());
        Queue<Reserva> fila = filaReservas.get(livro);

        for (Reserva r : fila) {
            if (r.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {
                return "Você já está na fila de reserva para este livro.";
            }
        }

        fila.add(new Reserva(nomeUsuario, livro));
        livro.setReservado(true);
        return "Reserva realizada com sucesso.";
    }

    public String cancelarReserva(String nomeUsuario, Livro livro) {
        Queue<Reserva> fila = filaReservas.get(livro);
        if (fila == null) return "Nenhuma reserva encontrada para este livro.";

        boolean removido = fila.removeIf(r -> r.getNomeUsuario().equalsIgnoreCase(nomeUsuario));
        if (removido) {
            if (fila.isEmpty()) livro.setReservado(false);
            return "Reserva cancelada com sucesso.";
        }
        return "Você não tem reserva neste livro.";
    }

    public List<String> listarFilaReserva(Livro livro) {
        Queue<Reserva> fila = filaReservas.get(livro);
        if (fila == null) return Collections.emptyList();
        List<String> nomes = new ArrayList<>();
        for (Reserva r : fila) nomes.add(r.getNomeUsuario());
        return nomes;
    }

    public Reserva proximaReserva(Livro livro) {
        Queue<Reserva> fila = filaReservas.get(livro);
        if (fila != null && !fila.isEmpty()) {
            return fila.peek();
        }
        return null;
    }
}