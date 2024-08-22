import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        Double imc;
        Double peso = 115.5;
        Double altura = 1.94;

        System.out.print("Entre com o valor do seu peso:");
        peso = ler.nextDouble();
        
        System.out.print("Entre com o valor da sua altura:");
        altura = ler.nextDouble();

        imc = peso / (altura * altura);
        System.out.printf("O seu imc é: %.2f%n",imc);
        ler.close();
    }

    
}
