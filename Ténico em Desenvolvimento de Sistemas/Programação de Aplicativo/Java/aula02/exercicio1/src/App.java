import java.util.Scanner;
import java.util.Locale;
import entities.rectangle;

public class App {
    
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        rectangle r = new rectangle();
        Scanner read = new Scanner(System.in);

        System.out.println("Entre com a altura e largura do Retangulo:");
        r.height = read.nextDouble();
        r.width = read.nextDouble();

        System.out.print("Area: "+ r.area()+"\n");
        System.out.print("Perimeter: "+r.perimeter()+ "\n");
        System.out.print("Diagonal: "+r.diagonal());
        

    }
}
