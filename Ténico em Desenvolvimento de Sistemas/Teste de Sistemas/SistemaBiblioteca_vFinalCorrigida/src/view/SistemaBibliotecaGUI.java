package view;

import model.Usuario;
import service.UsuarioService;
import javax.swing.*;
import java.awt.*;

public class SistemaBibliotecaGUI {
    static UsuarioService usuarioService = new UsuarioService();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaBibliotecaGUI::mostrarMenuInicial);
    }

    public static void mostrarMenuInicial() {
        JFrame frame = new JFrame("Sistema de Biblioteca - Autenticação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton btnCadastro = new JButton("Cadastrar Usuário");
        JButton btnLogin = new JButton("Login");
        JButton btnSair = new JButton("Sair");

        btnCadastro.addActionListener(e -> mostrarTelaCadastro());
        btnLogin.addActionListener(e -> mostrarTelaLogin());
        btnSair.addActionListener(e -> System.exit(0));

        panel.add(btnCadastro);
        panel.add(btnLogin);
        panel.add(btnSair);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void mostrarTelaCadastro() {
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField txtNome = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        String[] tipos = {"Bibliotecário", "Professor", "Aluno", "Visitante"};
        JComboBox<String> cbTipo = new JComboBox<>(tipos);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();
            String tipo = cbTipo.getSelectedItem().toString().toLowerCase();

            if (nome.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean sucesso = usuarioService.cadastrarUsuario(nome, senha, tipo);
            if (sucesso) {
                JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!");
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Usuário já existe.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel("Nome de usuário:")); panel.add(txtNome);
        panel.add(new JLabel("Senha:")); panel.add(txtSenha);
        panel.add(new JLabel("Tipo de usuário:")); panel.add(cbTipo);
        panel.add(new JLabel()); panel.add(btnCadastrar);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void mostrarTelaLogin() {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField txtNome = new JTextField();
        JPasswordField txtSenha = new JPasswordField();

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            Usuario u = usuarioService.autenticar(nome, senha);
            if (u != null) {
                JOptionPane.showMessageDialog(frame, "Bem-vindo, " + u.getNome() + " (" + u.getTipo() + ")");
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Credenciais inválidas.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel("Nome de usuário:")); panel.add(txtNome);
        panel.add(new JLabel("Senha:")); panel.add(txtSenha);
        panel.add(new JLabel()); panel.add(btnEntrar);

        frame.add(panel);
        frame.setVisible(true);
    }
}
