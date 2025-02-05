class MinhaRunnable implements Runnable {
    public void run() {
        // código a ser executado pela thread
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando " + Thread.currentThread().getName() + " Valor do contador: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        MinhaRunnable minhaRunnable = new MinhaRunnable();
        Thread thread_1 = new Thread(minhaRunnable);
        thread_1.start(); // Inicia a thread_1 e chama o metodo run()

        Thread thread_2 = new Thread(minhaRunnable);
        thread_2.start(); // Inicia a thread_2 e chama o metodo run()
    }
}
