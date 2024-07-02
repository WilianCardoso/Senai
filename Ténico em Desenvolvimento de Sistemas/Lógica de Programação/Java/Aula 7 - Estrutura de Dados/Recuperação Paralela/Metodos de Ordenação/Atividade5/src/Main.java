
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

 /*
    5- Elabore uma Classe para cada método de ordenação (Insertion, Selection, Bubble) e
crie um menu para o usuário escolher. Deverá ser solicitado ao usuário 10 números.

 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;

        System.out.println("============ M E N U =========");
        System.out.println("=        1-Insertion         =");
        System.out.println("=        2-Selection         =");
        System.out.println("=        3-Bubble            =");
        System.out.println("=        4-Sair              =");
        System.out.println("==============================");
        opcao = ler.nextInt();
        switch (opcao) {
            case 1:
                Insertion();
                break;
            case 2:
                Selection();
                break;
            case 3:
                Bubble();
                break;
            case 4:
                System.out.println("Sair");
                break;
        }
    }

    public static void Insertion() {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[10];
        int elementoAtual, indice;
        int tamanho = vetor.length;

        //Preenchimento do Vetor
        for (int i = 0; i < 10; i++) {
            System.out.print("Entre com o elemento do vetor:");
            vetor[i] = ler.nextInt();
        }

        System.out.print("\nVetor Original: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }

        //Ordenação
        for (int i = 0; i < tamanho; i++) {
            elementoAtual = vetor[i];
            indice = i;
            while (indice > 0 && vetor[indice - 1] > elementoAtual) {
                vetor[indice] = vetor[indice - 1];
                indice--;
            }
            vetor[indice] = elementoAtual;
        }

        //Escrita do vetor
        System.out.print("\nVetor Ordenado: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    public static void Selection() {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[10];
        int tamanho = vetor.length;
        int indice, auxiliar;

        //Preenchimento do Vetor
        for (int i = 0; i < 10; i++) {
            System.out.print("Entre com o elemento do vetor:");
            vetor[i] = ler.nextInt();
        }

        System.out.print("Vetor Original: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }

        //Ordenação
        for (int i = 0; i < tamanho - 1; i++) {
            indice = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (vetor[j] < vetor[indice]) {
                    indice = j;
                }
            }
            auxiliar = vetor[i];
            vetor[i] = vetor[indice];
            vetor[indice] = auxiliar;
        }
        //Escrita do vetor
        System.out.print("\nVetor Ordenado: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    public static void Bubble() {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[10];
        int tamanho = vetor.length;
        int auxiliar, j;

        //Preenchimento do Vetor
        for (int i = 0; i < 10; i++) {
            System.out.print("Entre com o elemento do vetor:");
            vetor[i] = ler.nextInt();
        }
        System.out.print("Vetor Original: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }
        //Ordenação
        for (j = 1; j <= tamanho; j++) {
            for (int i = 0; i < tamanho - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    auxiliar = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = auxiliar;
                }
            }
        }
        System.out.print("\nVetor Ordenado: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}
