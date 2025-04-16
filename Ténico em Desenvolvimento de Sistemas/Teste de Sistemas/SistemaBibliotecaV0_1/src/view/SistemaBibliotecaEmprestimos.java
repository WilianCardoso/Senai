// Arquivo: SistemaBibliotecaEmprestimos.java (com seleção múltipla de livros)
package view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Livro;
import model.Emprestimo;
import service.EmprestimoService;
import service.LivroService;
import service.UsuarioService;

public class SistemaBibliotecaEmprestimos {

    static UsuarioService usuarioService = new UsuarioService();
    static LivroService livroService = new LivroService();
    static EmprestimoService emprestimoService = new EmprestimoService();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaBibliotecaEmprestimos::mostrarMenu);
    }

    public static void mostrarMenu() {
        JFrame frame = new JFrame("Menu de Empréstimos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton btnEmprestar = new JButton("Realizar Empréstimo");
        JButton btnDevolver = new JButton("Devolver Livro");
        JButton btnHistorico = new JButton("Ver Histórico");
        JButton btnSair = new JButton("Sair");

        btnEmprestar.addActionListener(e -> realizarEmprestimoGUI());
        btnDevolver.addActionListener(e -> devolverLivroGUI());
        btnHistorico.addActionListener(e -> verHistoricoGUI());
        btnSair.addActionListener(e -> frame.dispose());

        panel.add(btnEmprestar);
        panel.add(btnDevolver);
        panel.add(btnHistorico);
        panel.add(btnSair);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void realizarEmprestimoGUI() {
        String nome = JOptionPane.showInputDialog("Nome do usuário:");
        List<Livro> livros = livroService.listarLivros();
        String[] titulos = livros.stream().map(Livro::getTitulo).toArray(String[]::new);

        JList<String> listaLivros = new JList<>(titulos);
        listaLivros.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaLivros);
        scrollPane.setPreferredSize(new Dimension(300, 150));
        int result = JOptionPane.showConfirmDialog(null, scrollPane, "Selecione livros para empréstimo", JOptionPane.OK_CANCEL_OPTION);

        if (result != JOptionPane.OK_OPTION) return;

        String dataStr = JOptionPane.showInputDialog("Data de devolução (dd/MM/yyyy):");
        try {
            Date dataDev = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
            for (String titulo : listaLivros.getSelectedValuesList()) {
                Livro livroEscolhido = livros.stream().filter(l -> l.getTitulo().equals(titulo)).findFirst().orElse(null);
                if (livroEscolhido != null) {
                    String resultado = emprestimoService.realizarEmprestimo(nome, livroEscolhido, dataDev, usuarioService);
                    JOptionPane.showMessageDialog(null, "Livro: " + titulo + "\n" + resultado);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data inválida.");
        }
    }

    public static void devolverLivroGUI() {
        String nome = JOptionPane.showInputDialog("Nome do usuário:");
        List<Emprestimo> lista = emprestimoService.listarEmprestimosPorUsuario(nome);
        List<Emprestimo> ativos = lista.stream().filter(e -> !e.isDevolvido()).toList();
        if (ativos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum empréstimo ativo encontrado.");
            return;
        }

        String[] titulos = ativos.stream().map(e -> e.getLivro().getTitulo()).toArray(String[]::new);
        String escolha = (String) JOptionPane.showInputDialog(null, "Escolha o livro para devolver:", "Devolução", JOptionPane.PLAIN_MESSAGE, null, titulos, titulos[0]);

        for (Emprestimo e : ativos) {
            if (e.getLivro().getTitulo().equals(escolha)) {
                emprestimoService.devolverLivro(e);
                JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso.");
                return;
            }
        }
    }

    public static void verHistoricoGUI() {
        String nome = JOptionPane.showInputDialog("Nome do usuário:");
        List<Emprestimo> lista = emprestimoService.listarEmprestimosPorUsuario(nome);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum histórico encontrado.");
            return;
        }

        StringBuilder sb = new StringBuilder("Histórico de Empréstimos:\n\n");
        for (Emprestimo e : lista) {
            sb.append("Livro: ").append(e.getLivro().getTitulo())
              .append(" | Devolvido: ").append(e.isDevolvido() ? "Sim" : "Não")
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}