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
        RunnableComParametro runTh1 = new RunnableComParametro("Thread 1", 1500);
        RunnableComParametro runTh2 = new RunnableComParametro("Thread 2", 4500);
        
        Thread thread1 = new Thread(runTh1);
        Thread thread2 = new Thread(runTh2);
        thread1.start();
        thread2.start();

        System.out.println("Programa finalizado!!!");

       // MinhaRunnable minhaRunnable = new MinhaRunnable();
      //  Thread thread_1 = new Thread(minhaRunnable);
      //  thread_1.start(); // Inicia a thread_1 e chama o metodo run()

       // Thread thread_2 = new Thread(minhaRunnable);
        //thread_2.start(); // Inicia a thread_2 e chama o metodo run()
    }
}
