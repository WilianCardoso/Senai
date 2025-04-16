package view;

import javax.swing.*;
import java.awt.*;

public class SistemaBibliotecaMenuPrincipal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaBibliotecaMenuPrincipal::mostrarMenuPrincipal);
    }

    public static void mostrarMenuPrincipal() {
        JFrame frame = new JFrame("📚 SISTEMA DE BIBLIOTECA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 1, 10, 10));

        JButton btn1 = new JButton("🔐 1. Autenticação");
        JButton btn2 = new JButton("👤 2. Gestão de Usuários");
        JButton btn3 = new JButton("📖 3. Gestão de Livros");
        JButton btn4 = new JButton("🔄 4. Empréstimos e Devoluções");
        JButton btn5 = new JButton("📆 5. Reservas");
        JButton btn6 = new JButton("💸 6. Multas");
        JButton btn7 = new JButton("📊 7. Relatórios e Estatísticas");
        JButton btn8 = new JButton("⚙️ 8. Configurações");
        JButton btn9 = new JButton("🧩 9. Extras / Funcionalidades Adicionais");

        btn1.addActionListener(e -> SistemaBibliotecaGUI.main(null));
        btn2.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Gestão de Usuários ainda não implementada."));
        btn3.addActionListener(e -> SistemaBibliotecaLivros.main(null));
        btn4.addActionListener(e -> SistemaBibliotecaEmprestimos.main(null));
        btn5.addActionListener(e -> SistemaBibliotecaReservas.main(null));
        btn6.addActionListener(e -> SistemaBibliotecaMultas.main(null));
        btn7.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Relatórios ainda não implementados."));
        btn8.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Configurações ainda não implementadas."));
        btn9.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Funcionalidades Extras ainda não implementadas."));

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);

        frame.add(panel);
        frame.setVisible(true);
    }
}