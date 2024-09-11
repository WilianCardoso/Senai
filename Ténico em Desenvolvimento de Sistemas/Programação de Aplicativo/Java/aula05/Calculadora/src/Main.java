import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultadob;

    public Main() {
        // Configuração do frame - Titulo
        setTitle("Calculadora");
        setSize(1000, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);// modo de fechamento do sistema

        // num1Field.setBounds(200, 150, 100, 30);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);

        JButton addButton = new JButton("Adicionar");
        JButton subButton = new JButton("Subtrair");
        JButton mulButton = new JButton("Multiplica");
        JButton divButton = new JButton("Dividir");
        resultadob = new JLabel("Resultado");

        panel.add(new JLabel("numero 1"));
        panel.add(num1Field);
        panel.add(new JLabel("numero 2"));
        panel.add(num2Field);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(resultadob);
        add(panel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacaoMatematica('+');
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacaoMatematica('-');
            }
        });

        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacaoMatematica('*');
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacaoMatematica('/');
            }
        });

    }

    private void operacaoMatematica(char operador) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double resultado = 0;

            switch (operador) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        resultadob.setText("Erro, Divisão por zero!");
                        return;
                    }
                    break;
                default:
                    break;
            }
            resultadob.setText("Resultado " + resultado);
        } catch (Exception e) {
            resultadob.setText("Erro: Entrada inválida");
        }
    }

    public static void main(String[] args) throws Exception {
        Main frame = new Main();
        // visibilidade
        frame.setVisible(true);
    }
}
