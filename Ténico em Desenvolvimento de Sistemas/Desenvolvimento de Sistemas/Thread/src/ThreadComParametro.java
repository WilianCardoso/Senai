
public class ThreadComParametro extends Thread {
    private String nmThread;
    private int tempo;

    public ThreadComParametro(String nome, int tempo) {
        this.tempo = tempo;
        this.nmThread = nome;
        start();
    }

    @Override
    public void run() {
        // Código a ser executado pela therad
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(nmThread + "contador " + i);
                Thread.sleep(tempo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(nmThread + " terminou a execução.");

    }
}
