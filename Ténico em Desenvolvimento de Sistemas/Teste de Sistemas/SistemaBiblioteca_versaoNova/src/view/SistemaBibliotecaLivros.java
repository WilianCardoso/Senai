package view;

import service.LivroService;
import model.Livro;
import javax.swing.*;
import java.awt.*;
import java.util.List;


public class SistemaBibliotecaLivros {

    static LivroService livroService = new LivroService();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaBibliotecaLivros::mostrarMenuLivros);
    }

    public static void mostrarMenuLivros() {
        JFrame frame = new JFrame("Gestão de Livros");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton btnCadastrar = new JButton("Cadastrar Livro");
        JButton btnBuscar = new JButton("Buscar Livro");
        JButton btnListar = new JButton("Listar Todos os Livros");
        JButton btnSair = new JButton("Sair");

        btnCadastrar.addActionListener(e -> mostrarTelaCadastro());
        btnBuscar.addActionListener(e -> mostrarTelaBusca());
        btnListar.addActionListener(e -> mostrarTodosOsLivros());
        btnSair.addActionListener(e -> frame.dispose());

        panel.add(btnCadastrar);
        panel.add(btnBuscar);
        panel.add(btnListar);
        panel.add(btnSair);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void mostrarTelaCadastro() {
        JFrame frame = new JFrame("Cadastrar Livro");
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));
        JTextField txtTitulo = new JTextField();
        JTextField txtAutor = new JTextField();
        JTextField txtEditora = new JTextField();
        JTextField txtISBN = new JTextField();
        JTextField txtCategoria = new JTextField();
        JTextField txtLocal = new JTextField();

        JButton btnSalvar = new JButton("Salvar");

        btnSalvar.addActionListener(e -> {
            Livro livro = new Livro(
                txtTitulo.getText(), txtAutor.getText(), txtEditora.getText(),
                txtISBN.getText(), txtCategoria.getText(), txtLocal.getText()
            );
            livroService.cadastrarLivro(livro);
            JOptionPane.showMessageDialog(frame, "Livro cadastrado com sucesso!");
            frame.dispose();
        });

        panel.add(new JLabel("Título:")); panel.add(txtTitulo);
        panel.add(new JLabel("Autor:")); panel.add(txtAutor);
        panel.add(new JLabel("Editora:")); panel.add(txtEditora);
        panel.add(new JLabel("ISBN:")); panel.add(txtISBN);
        panel.add(new JLabel("Categoria:")); panel.add(txtCategoria);
        panel.add(new JLabel("Local na Estante:")); panel.add(txtLocal);
        panel.add(new JLabel()); panel.add(btnSalvar);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void mostrarTelaBusca() {
        String termo = JOptionPane.showInputDialog("Digite o título para buscar:");
        if (termo != null && !termo.trim().isEmpty()) {
            List<Livro> resultados = livroService.buscarPorTitulo(termo);
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum livro encontrado.");
            } else {
                StringBuilder sb = new StringBuilder("Resultados:\n\n");
                for (Livro l : resultados) {
                    sb.append("• ").append(l.getTitulo()).append(" - ").append(l.getAutor()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        }
    }

    public static void mostrarTodosOsLivros() {
        List<Livro> todos = livroService.listarLivros();
        if (todos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder("Lista de Livros:\n\n");
            for (Livro l : todos) {
                sb.append("• ").append(l.getTitulo()).append(" - ").append(l.getAutor()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
