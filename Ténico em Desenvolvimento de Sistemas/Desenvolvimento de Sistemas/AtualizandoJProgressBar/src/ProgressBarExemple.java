import javax.swing.SwingUtilities;

public class ProgressBarExemple {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MinhaProgressBar exemple = new MinhaProgressBar();
                exemple.setVisible(true);
                exemple.iniciarTarefa();
            }
        });
    }
}
