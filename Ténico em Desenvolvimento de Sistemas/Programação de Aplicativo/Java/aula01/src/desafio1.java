import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class desafio1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        //Double a, b, c, p, 
        double area1, area2;

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();
        

        System.out.print("Entre com os valores do triangulo X:");
        x.a = read.nextDouble();

        x.b = read.nextDouble();

        x.c = read.nextDouble();

        area1 = x.area();

        System.out.print("Entre com os valores do triangulo Y:");

        y.a = read.nextDouble();

        y.b = read.nextDouble();

        y.c = read.nextDouble();

        area2 = y.area();

        System.out.printf("A area do trianguloX e: %.4f%n", area1);
        System.out.printf("A area do trianguloY e: %.4f%n", area2);

        if(area1 > area2){
            System.out.println("TrianguloX e maior");
        }else{
            System.out.println("TrianguloY e maior");
        }
    }
    

}
