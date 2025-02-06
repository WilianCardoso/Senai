import javax.swing.*;
import java.awt.*;

public class TextFileReaderGUI extends JFrame {
    private JTextArea textArea;

    public TextFileReaderGUI() {
        setTitle("Leitor de Arquivo Texto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Inicializando o JTextArea
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 16));

        // Adicionando o JTextArea a um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 200, 300);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void loadFilesSimultaneously(String filePath1, String filePath2) {
        TarefaLerArquivo task1 = new TarefaLerArquivo(filePath1, textArea);
        TarefaLerArquivo task2 = new TarefaLerArquivo(filePath2, textArea);

        // Criando threads para cada tarefa de leitura de arquivo
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Iniciando as threads
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {

    }
}
