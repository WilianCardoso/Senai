
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
    FilaNomes fila = new FilaNomes();
    int opcao = 0;
    String e;
    Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here

    }

    public void Menu() {
        while (opcao != 5) {
            System.out.println("============ M E N U =========");
            System.out.println("=                            =");
            System.out.println("= 1-Enqueue                  =");
            System.out.println("= 2-Dequeue                  =");
            System.out.println("= 3-Peek                     =");
            System.out.println("= 4-isEmpty                  =");
            System.out.println("= 5-Sair                     =");
            System.out.println("==============================");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    fila.adicionar(e);
                    break;
                case 2:
                    fila.remover();
                    break;
                case 3:
                    fila.empilha(p1);
                    break;
                case 4:
                    fila.print();
                    break;
                case 5:
                    opcao = ler.nextInt();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
