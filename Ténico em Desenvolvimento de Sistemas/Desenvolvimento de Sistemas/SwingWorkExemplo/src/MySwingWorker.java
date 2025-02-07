
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MySwingWorker extends SwingWorker<String, Integer>{
    private final JProgressBar progressBar;
    private final JTextArea textArea;
    private JButton button;

    public MySwingWorker(JProgressBar progressBar, JTextArea textArea, JButton button){
        this.progressBar = progressBar;
        this.textArea = textArea;
        this.button = button;
    }
    @Override
    protected  String doInBackground() throws Exception{
        // Simula uma tarefa de longa duração
        for(int i =0; i<=100; i++){
            Thread.sleep(100);
            publish(i);
            setProgress(i);
        }
        return "Tarefa concluída com sucesso!";
    }
    
    protected void progress(List<Integer> chunks){
        // Atualiza a interface grafica com os resultados intermediários

        for (int chunk : chunks){
            progressBar.setValue(chunk);
            textArea.append("Progresso: " + chunk + "%\n");
        }
    }

    @Override
    protected void done(){
        try {
            //Obtem o resultado da tarefa do método doInBackground
            String result = get();
            textArea.append(result + "\n");
            button.setEnabled(true);
            button.setText("Iniciar tarefa");    
        } catch (InterruptedException | ExecutionException e) {
            textArea.append("Erro: " + e.getMessage());
        }
    }
}
