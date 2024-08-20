import java.util.Locale;
import java.util.Scanner;

public class desafio1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Double a, b, c, p, area1, area2;

        System.out.print("Entre com o primeiro valor:");
        a = read.nextDouble();

        System.out.print("Entre com o segundo valor:");
        b = read.nextDouble();

        System.out.print("Entre com o terceiro valor:");
        c = read.nextDouble();

        p = (a + b + c) / 2;

        area1 = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("A área do trianguloX é: %.2f\n" + area1);

        System.out.print("Entre com o primeiro valor:");
        a = read.nextDouble();

        System.out.print("Entre com o segundo valor:");
        b = read.nextDouble();

        System.out.print("Entre com o terceiro valor:");
        c = read.nextDouble();

        p = (a + b + c) / 2;

        area2 = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println("A área do trianguloY é: %.2f\n" + area2);

    }

}
