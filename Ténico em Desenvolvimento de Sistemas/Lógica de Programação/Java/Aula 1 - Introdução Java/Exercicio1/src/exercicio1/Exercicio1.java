/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio1;

import java.util.Scanner;

/**
 *
 * @author wilian_g_cardoso
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nm1, nm2, result;

        System.out.println("Entre com o primeiro número: ");
        nm1 = input.nextInt();
        System.out.println("Entre com o segundo número: ");
        nm2 = input.nextInt();

        result = nm1 + nm2;

        System.out.println("O resultado dessa operação é"+result+".");

    }

}
