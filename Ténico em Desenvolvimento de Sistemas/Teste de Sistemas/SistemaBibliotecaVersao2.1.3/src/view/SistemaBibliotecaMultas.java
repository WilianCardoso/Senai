package view;

import model.Multa;
import service.MultaService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SistemaBibliotecaMultas {

    static MultaService multaService = new MultaService();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaBibliotecaMultas::mostrarMenu);
    }

    public static void mostrarMenu() {
        JFrame frame = new JFrame("💸 Multas");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        JButton btnVer = new JButton("Visualizar Multas");
        JButton btnPagar = new JButton("Pagar Multas");

        btnVer.addActionListener(e -> visualizarMultasGUI());
        btnPagar.addActionListener(e -> pagarMultasGUI());

        panel.add(btnVer);
        panel.add(btnPagar);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void visualizarMultasGUI() {
        String nome = JOptionPane.showInputDialog("Nome do usuário:");
        List<Multa> lista = multaService.listarMultasPorUsuario(nome);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma multa encontrada.");
            return;
        }
        StringBuilder sb = new StringBuilder("Multas do usuário:\n\n");
        for (Multa m : lista) {
            sb.append("• R$ ").append(String.format("%.2f", m.getValor()))
              .append(" | Gerada em: ").append(m.getDataGerada())
              .append(" | Status: ").append(m.isPaga() ? "PAGA" : "EM ABERTO").append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void pagarMultasGUI() {
        String nome = JOptionPane.showInputDialog("Nome do usuário:");
        boolean pagou = multaService.pagarMultasDoUsuario(nome);
        if (pagou) {
            JOptionPane.showMessageDialog(null, "Multas pagas com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma multa em aberto para esse usuário.");
        }
    }
}