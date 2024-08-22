import java.util.Scanner;

import entities.product;

public class App {
    public static void main(String[] args) throws Exception {
        product p;
        p = new product();

        Scanner read = new Scanner(System.in);

        System.out.println("Adicione seu produto:");
        System.out.print("Nome:");
        p.name = read.next();
        System.out.print("Price:");
        p.price = read.nextDouble();
        System.out.print("Quantity:");
        p.quantity = read.nextInt();

        System.out.println("Product data: " + p.name + ", $ " + p.price + ", " + p.quantity
                + " unidades, Total no estoque: $ " + p.TotalValueStock());

        System.out.println("Adicione produtos no estoque: ");
        p.quantity = read.nextInt();

        System.out.println("Update data: " + p.name + ", $ " + p.price + ", " + p.quantity
                + " unidades, Total no estoque: $ " + p.TotalValueStock());

        System.out.println("Remova produtos no estoque: " + p.name + ", $ " + p.price + ", " + p.quantity
                + " unidades, Total no estoque: $ " + p.TotalValueStock());
        p.quantity = read.nextInt();
    }
}
