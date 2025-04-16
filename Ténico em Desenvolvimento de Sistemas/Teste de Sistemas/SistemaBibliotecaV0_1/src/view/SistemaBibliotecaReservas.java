package view;

import model.Livro;
import service.LivroService;
import service.ReservaService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SistemaBibliotecaReservas {

    static LivroService livroService = new LivroService();
    static ReservaService reservaService = new ReservaService();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaBibliotecaReservas::mostrarMenu);
    }

    public static void mostrarMenu() {
        JFrame frame = new JFrame("📆 Reservas");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton btnReservar = new JButton("Solicitar Reserva");
        JButton btnCancelar = new JButton("Cancelar Reserva");
        JButton btnFila = new JButton("Ver Fila de Espera");

        btnReservar.addActionListener(e -> solicitarReservaGUI());
        btnCancelar.addActionListener(e -> cancelarReservaGUI());
        btnFila.addActionListener(e -> verFilaGUI());

        panel.add(btnReservar);
        panel.add(btnCancelar);
        panel.add(btnFila);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void solicitarReservaGUI() {
        String nome = JOptionPane.showInputDialog("Nome do usuário:");
        List<Livro> livros = livroService.listarLivros();
        String[] titulos = livros.stream().map(Livro::getTitulo).toArray(String[]::new);
        String selecionado = (String) JOptionPane.showInputDialog(null, "Escolha um livro emprestado:", "Reserva", JOptionPane.PLAIN_MESSAGE, null, titulos, titulos[0]);

        Livro livroEscolhido = livros.stream().filter(l -> l.getTitulo().equals(selecionado)).findFirst().orElse(null);
        if (livroEscolhido == null) return;

        String msg = reservaService.reservarLivro(nome, livroEscolhido);
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void cancelarReservaGUI() {
        String nome = JOptionPane.showInputDialog("Nome do usuário:");
        List<Livro> livros = livroService.listarLivros();
        String[] titulos = livros.stream().map(Livro::getTitulo).toArray(String[]::new);
        String selecionado = (String) JOptionPane.showInputDialog(null, "Escolha um livro:", "Cancelar Reserva", JOptionPane.PLAIN_MESSAGE, null, titulos, titulos[0]);

        Livro livroEscolhido = livros.stream().filter(l -> l.getTitulo().equals(selecionado)).findFirst().orElse(null);
        if (livroEscolhido == null) return;

        String msg = reservaService.cancelarReserva(nome, livroEscolhido);
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void verFilaGUI() {
        List<Livro> livros = livroService.listarLivros();
        String[] titulos = livros.stream().map(Livro::getTitulo).toArray(String[]::new);
        String selecionado = (String) JOptionPane.showInputDialog(null, "Escolha um livro:", "Fila de Espera", JOptionPane.PLAIN_MESSAGE, null, titulos, titulos[0]);

        Livro livroEscolhido = livros.stream().filter(l -> l.getTitulo().equals(selecionado)).findFirst().orElse(null);
        if (livroEscolhido == null) return;

        List<String> fila = reservaService.listarFilaReserva(livroEscolhido);
        if (fila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há ninguém na fila de espera.");
        } else {
            JOptionPane.showMessageDialog(null, "Fila de Espera:\n" + String.join("\n", fila));
        }
    }
}