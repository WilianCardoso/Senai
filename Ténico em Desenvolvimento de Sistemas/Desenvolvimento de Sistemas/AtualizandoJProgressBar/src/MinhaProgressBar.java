import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class MinhaProgressBar extends JFrame {
    private JProgressBar progressBar;

    public MinhaProgressBar() {
        setTitle("Exemplo de JProgressBar");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializando a JProgressBar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        // Adicionando a JProgressBar ao JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(progressBar, BorderLayout.CENTER);
    }

    public void iniciarTarefa() {
        // Criando uma thread para iniciar uma tarefa que leva tempo
        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        final int progress = i;
                        // Atualizando a JProgressBar no EDT
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setValue(progress);
                            }
                        });
                        // Simulando uma tarefa que leva tempo
                        Thread.sleep(1000); // Espera 100ms
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        taskThread.start();
    }
}
