import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {

    public Main() {
        setTitle("Titulo");// título da tela
        setSize(300, 200);// Deefini dimensao da tela
        setDefaultCloseOperation(EXIT_ON_CLOSE);// encerrar preocesso quando fechar
        setLocationRelativeTo(null);// centralizar a tela do aplicativo
        setLayout(new BorderLayout());// borda

        JPanel panel = new JPanel();// instanciando o objeto panel
        panel.setLayout(new FlowLayout());// layout no panel
        // Defini o tamanho do panel
        panel.setPreferredSize(new Dimension(200, 100));

        JLabel lblNome = new JLabel("Nome");// instancia o obj lblNome
        lblNome.setBounds(15, 10, 100, 30);// defini a inicialização
        lblNome.setFont(new Font("Arial", Font.BOLD, 16));// ajustar fonte e formatação
        lblNome.setForeground(Color.GRAY);
        lblNome.setBackground(Color.BLACK);
        lblNome.setIcon(new ImageIcon(""));// colocar icone
        lblNome.setToolTipText("Informe seu nome");
        add(lblNome);// add nome na tela

        JLabel lblSobrenome = new JLabel("Sobrenome");
        lblSobrenome.setBounds(10, 60, 100, 30);// defini a inicialização
        lblSobrenome.setFont(new Font("Arial", Font.BOLD, 16));// ajustar fonte e formatação
        lblSobrenome.setForeground(Color.GRAY);
        lblSobrenome.setBackground(Color.BLACK);
        lblSobrenome.setIcon(new ImageIcon(""));// colocar icone
        lblSobrenome.setToolTipText("Informe seu nome");
        add(lblSobrenome);// add nome na tela

        JTextField txtNome = new JTextField();
        txtNome.setBounds(15, 35, 200, 30);
        // txtNome.setEditable(false);//tornar não editavel
        txtNome.setFont(new Font("Arial", Font.BOLD, 16));// ajustar fonte e formatação
        add(txtNome);// add na tela

        JTextField txtSobrenome = new JTextField();
        txtSobrenome.setBounds(15, 85, 200, 30);
        // txtNome.setEditable(false);//tornar não editavel
        txtSobrenome.setFont(new Font("Arial", Font.BOLD, 16));// ajustar fonte e formatação
        add(txtSobrenome);// add na tela

        JButton addButton = new JButton("Exibir Menssagem");
        addButton.setBounds(15, 120, 150, 30);
        addButton.setName("btmenssagem");// nomeado
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtNome.getText().isEmpty()) {// se vazio ele escreve a msg
                    JOptionPane.showMessageDialog(null, "Campo está vazio");

                } else {// caso contrário ele escreve Bem Vindo
                    JOptionPane.showMessageDialog(null,
                            "Bem vindo " + txtNome.getText() + " " + txtSobrenome.getText());
                    txtNome.setText("");
                    txtSobrenome.setText("");
                }
            }

        });

        JButton addButtonExt = new JButton("Sair");
        addButtonExt.setBounds(170, 120, 100, 30);
        addButtonExt.setName("btexit");// nomeado
        add(addButtonExt);

        addButtonExt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Encerrando o aplicativo...");
                System.exit(0);
            }

        });

        add(panel);// add o panel na tela
    }

    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
