import java.util.Locale;
import java.util.Scanner;

public class raiz {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        
        double valor, resultado;
        Scanner ler = new Scanner(System.in);
        System.out.print("Entre com o valor que quer transformar em raiz quadrada: ");
        valor = ler.nextDouble();
        resultado = Math.sqrt(valor);
        System.out.printf("O valor "+ valor +" transformado em raiz quadrada é: %.2f\n", resultado);
    }
}
