/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Default;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author wilian_g_cardoso
 */
public class BlocodeNotas extends javax.swing.JFrame {

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu menuEditar, menuArquivo;
    private JMenuItem menuNovo, menuAbrir, menuSalvar, menuSair, menuClaro, menuEscuro, menuConfigFont;
    private int resposta;

    public BlocodeNotas() {
        // initComponents();

        setTitle("Bloco de Notas");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //dispose_on_close, nothing_on_close, hide_on_close
        setLocationRelativeTo(null);//ficar no centro
        setResizable(false);//para impossiblitar ajustar a tela
        //pack();//ajustar a tela de acordo com os componentes internos

        //instanciando o JtextArea 
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        //Barra de menu
        menuBar = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuEditar = new JMenu("Editar");
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);

        //Itens
        menuNovo = new JMenuItem("Novo");
        menuAbrir = new JMenuItem("Abrir");
        menuSalvar = new JMenuItem("Salvar");
        menuSair = new JMenuItem("Sair");

        menuArquivo.add(menuNovo);
        menuArquivo.add(menuAbrir);
        menuArquivo.add(menuSalvar);
        menuArquivo.addSeparator();//Colcar uma linha para diferenciar
        menuArquivo.add(menuSair);

        menuClaro = new JMenuItem("Claro");
        menuEscuro = new JMenuItem("Escuro");
        menuConfigFont = new JMenuItem("Fonte");

        menuEditar.add(menuClaro);
        menuEditar.add(menuEscuro);
        menuEditar.add(menuConfigFont);

        setJMenuBar(menuBar); //Adicionar menu ao frame

        menuNovo.addActionListener(e -> novoArquivo());
        menuClaro.addActionListener(e -> menuClaro());
        menuEscuro.addActionListener(e -> menuEscuro());
        menuSalvar.addActionListener(e -> salvarArquivo());
        menuSair.addActionListener(e -> System.exit(0));
        menuAbrir.addActionListener(e -> abrirAquivo());

    }

    private void novoArquivo() {
        if (textArea.getText().isEmpty()) {
            textArea.setText("");
        } else {
            resposta = JOptionPane.showConfirmDialog(null, "Deseja salvar as Alterações?", "Confirmação", JOptionPane.YES_NO_OPTION);

        }

        if (resposta == JOptionPane.YES_NO_OPTION) {
            salvarArquivo();
        } else {
            textArea.setText("");
        }

    }

    private void menuClaro() {
        menuClaro.addActionListener(e -> {
            textArea.setBackground(Color.WHITE);
            textArea.setForeground(Color.BLACK);
            Font font = new Font("Arial", Font.PLAIN, 18);
            textArea.setFont(font);
            revalidate();
            repaint();
        });
    }

    private void menuEscuro() {
        menuEscuro.addActionListener(e -> {
            textArea.setBackground(Color.BLACK);
            textArea.setForeground(Color.WHITE);
            Font font = new Font("Arial", Font.PLAIN, 18);
            textArea.setFont(font);
            revalidate();
            repaint();
        });
    }

    private void abrirAquivo() {
        JFileChooser arquivo = new JFileChooser();
        int option = arquivo.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File arquivoB = arquivo.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(arquivoB));
                textArea.read(reader, null);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();//nome, mensagem, lista de erro
            }
        }
    }

    private void salvarArquivo() {
        JFileChooser arquivo = new JFileChooser();
        int option = arquivo.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File arquivoB = arquivo.getSelectedFile();
                BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoB));
                textArea.write(escritor);
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void configFont() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BlocodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlocodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlocodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlocodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlocodeNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
