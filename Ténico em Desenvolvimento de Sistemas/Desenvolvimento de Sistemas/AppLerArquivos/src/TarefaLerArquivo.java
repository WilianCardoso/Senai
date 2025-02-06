import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TarefaLerArquivo implements Runnable {
    private final String filePath;
    private final JTextArea textArea;

    public TarefaLerArquivo(String filePath, JTextArea textArea) {
        this.filePath = filePath;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String currentLine = line;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (textArea) {
                            textArea.append(currentLine + "\n");
                        }
                    }
                });
                Thread.sleep(1000); // Espera 1 segundo antes de ler a próxima linha
            }
        } catch (IOException e) {
            showError("Erro ao ler o arquivo: " + e.getMessage());
        } catch (InterruptedException e) {
            showError("A leitura do arquivo foi interrompida: " + e.getMessage());
        }
    }

    private void showError(final String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(textArea.getParent(), message, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
