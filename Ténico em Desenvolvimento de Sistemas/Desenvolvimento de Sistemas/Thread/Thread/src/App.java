class MinhaThread extends Thread {

    private int tempo;

    public MinhaThread(Integer tempo) {
        this.tempo = tempo;
    }

    public void run() {
        // Código a ser executado pela therad
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando " + Thread.currentThread().getName() + " Valor do contador :" + i);
            try {
                Thread.sleep(2000); // pausa a thread por 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        MinhaThread thread_1 = new MinhaThread(1000);
        thread_1.start();

        MinhaThread thread_2 = new MinhaThread(2000);
        thread_2.start();

        System.out.println("Programa Finalizado");
    }
}
