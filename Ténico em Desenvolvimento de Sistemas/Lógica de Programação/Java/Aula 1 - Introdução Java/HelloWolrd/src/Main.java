
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
           System.out.println("Hello World");
           Scanner input = new Scanner(System.in);
           
           //Recebe nome
           String nome;
           
           //Leitura da entrada pelo teclado
           System.out.println("Informe o seu nome?");
           nome = input.nextLine();
           
           //saida do nome informado
           System.out.println("Aeu nome é: "+nome+".");
         
    }
    
}
