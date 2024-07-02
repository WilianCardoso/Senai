
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
        // TODO code application logic here
        int opcao = 0, continuar = 0;
        double nm1, result;
        float cotacao;

        while (opcao != 5) {
            Scanner input = new Scanner(System.in);
            System.out.println("|===================================|");
            System.out.println("| Informe qual a conversao desejada |");
            System.out.println("| Opcao 1 - Converter Moeda         |");
            System.out.println("| Opcao 2 - Converter Velocidade    |");
            System.out.println("| Opcao 3 - Converter Peso          |");
            System.out.println("| Opcao 4 - Converter Comprimento   |");
            System.out.println("| Opcao 5 - Sair                    |");
            System.out.println("|===================================|");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    while (continuar == 1) {
                        System.out.println("Informe o valor da moeda: ");
                    }
                    nm1 = input.nextDouble();
                    System.out.println("Informe o valor da cotacao: ");
                    cotacao = input.nextFloat();
                    result = nm1 / cotacao;
                    System.out.println("O valor da conversao e " + result);
                    break;
                case 2:
                    int nm2,
                     opcao2 = 0;
                    System.out.println("Informe em qual unidade de velocidade voce quer converter");
                    System.out.println("1 - km/h para m/s\n"
                            + "2 - km/h para Mph/h\n"
                            + "3 - km/h para Velocidade da luz");
                    opcao2 = input.nextInt();
                    if (opcao2 == 1) {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 / 3.6;
                        System.out.println("O valor da velocidade convertido em m/s e " + result);

                    } else if (opcao2 == 2) {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 / 1.609344;
                        System.out.println("O valor da velocidade convertido em Mph/h e" + result);
                    } else {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 / 3.6;
                        result = result / 299792458;
                        System.out.println("O valor da velocidade convertido na velocidade da luz e " + result);
                    }
                    break;

                case 3:
                    System.out.println("Informe qual o tipo da conversão: ");
                    System.out.println("1 - kg para grama\n"
                            + "2 - kg para libra\n"
                            + "3 - kg para miligrama\n"
                            + "4 - kg para onca");
                    opcao2 = input.nextInt();
                    if (opcao2 == 1) {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 * 1000;
                        System.out.println("O valor de kg para gramas ficou: " + result);
                    } else if (opcao2 == 2) {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 * 2.205;
                        System.out.println("O valor aproximado de kg para libras ficou: " + result);
                    } else if (opcao2 == 3) {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 * 1000000;
                        System.out.println("O valor de kg para miligramas ficou: " + result);
                    } else {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 * 35.274;
                        System.out.println("O valor de kg para miligramas ficou: " + result);
                    }

                    break;
                case 4:
                    System.out.println("Informe qual o tipo da conversão: ");
                    System.out.println("1 - centimetros para metro\n"
                            + "2 - centimetros para jardas\n"
                            + "3 - centimetros para picometro");
                    opcao2 = input.nextInt();
                    if (opcao2 == 1) {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 / 100;
                        System.out.println("O valor de cm para metros ficou: " + result);
                    } else if (opcao2 == 2) {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 / 91.44;
                        System.out.println("O valor de cm para jardas ficou: " + result);
                    } else if (opcao2 == 3) {
                        System.out.println("Entre com um valor");
                        nm2 = input.nextInt();
                        result = nm2 * 1e10;
                        System.out.println("O valor de kg para miligramas ficou: " + result);
                    }
                    break;
                case 5:
                    System.out.println("Sair ");
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
