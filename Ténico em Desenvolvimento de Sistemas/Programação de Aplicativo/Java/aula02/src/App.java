import java.util.Locale;
import java.util.Scanner;

import entities.product;

public class App {
        public static void main(String[] args) throws Exception {
                Locale.setDefault(Locale.US);
                product p = new product();
                Scanner read = new Scanner(System.in);

                System.out.println("Adicione seu produto:");
                System.out.print("Nome:");
                p.name = read.nextLine();

                System.out.print("Price:");
                p.price = read.nextDouble();

                System.out.print("Quantity:");
                p.quantity = read.nextInt();
                System.out.println();

                System.out.println("Product data: " + p);
                System.out.println();

                System.out.println("Adicione produtos no estoque: " + p);
                int quantity = read.nextInt();
                p.addProducts(quantity);
                System.out.println();

                System.out.println("Update data: " + p);
                System.out.println();

                System.out.println("Remova produtos no estoque: " + p);
                quantity = read.nextInt();
                p.removeProducts(quantity);
                System.out.println();

                System.out.println("Update data: " + p);
                read.close();
        }
}
