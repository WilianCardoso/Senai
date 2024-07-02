
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author wilian_g_cardoso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu();

    }

    public static void Menu() {
        int menu = 0;
        boolean sair = false;
        Scanner ler = new Scanner(System.in);
        PilhaNumeros p1 = new PilhaNumeros();
        while (sair == false) {
            System.out.println("============ M E N U =========");
            System.out.println("=                            =");
            System.out.println("= 1-Empilhar                 =");
            System.out.println("= 2-Desempilhar              =");
            System.out.println("= 3-Verificar se esta  vazio =");
            System.out.println("= 4-Verificar se esta  cheio =");
            System.out.println("= 5-Sair                     =");
            System.out.println("==============================");
            menu = ler.nextInt();
            switch (menu) {
                case 1:
                    p1.push();
                    break;
                case 2:
                    p1.pop();
                    break;
                case 3:
                    p1.empilha(p1);
                    break;
                case 4:
                    p1.print();
                    break;
                case 5:
                    sair = ler.nextBoolean();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
