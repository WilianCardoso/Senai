
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
        int opcao = 0;
        int nm1, nm2;    
        while (opcao != 5) {
            Scanner input = new Scanner(System.in);
            System.out.println("|=============================================|");
            System.out.println("| Informe qual a operacao que deseja realizar |");
            System.out.println("| Opcao 1 - Adicao                            |");
            System.out.println("| Opcao 2 - Subtracao                         |");
            System.out.println("| Opcao 3 - Multiplicacao                     |");
            System.out.println("| Opcao 4 - Divisao                           |");
            System.out.println("| Opcao 5 - Sair                              |");
            System.out.println("|=============================================|");
            opcao = input.nextInt();
            System.out.println("Entre com o primeiro valor");
            nm1 = input.nextInt();
            System.out.println("Entre com o segundo valor");
            nm2 = input.nextInt();
           
            switch (opcao) {
                case 1:
                    calculadora.adicao(nm1, nm2);
                    break;
                case 2:
                    calculadora.subtracao(nm1, nm2);
                    break;
                case 3:
                    calculadora.multiplicacao(nm1, nm2);
                    break;
                case 4:
                    calculadora.divisao(nm1, nm2);
                    break;
                case 5:

                default:
                    throw new AssertionError();
            }
        }

    }
}
