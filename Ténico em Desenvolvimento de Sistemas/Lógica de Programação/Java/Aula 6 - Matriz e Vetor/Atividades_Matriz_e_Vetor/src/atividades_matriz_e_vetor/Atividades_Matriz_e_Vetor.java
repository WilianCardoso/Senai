/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividades_matriz_e_vetor;

import java.util.Scanner;

/**
 *
 * @author wilian_g_cardoso
 */
public class Atividades_Matriz_e_Vetor {

    public static void main(String[] args) {
        //atividade1();
        //atividade2();
        //atividade3();
        //atividade4();
        //atividade5();
        //atividade6();
    }

    public static void atividade1() {
        /*1- Pedir 5 numeros pro usuário e armazenar em um vetor. 
        mostrar o maior, menor, media e soma.*/

        Scanner ler = new Scanner(System.in);
        int[] numeros = new int[5];
        int media = 0, soma = 0, tamanho, j;
        for (int i = 0; i < 5; i++) {
            System.out.print("Entre com um numero:");
            numeros[i] = ler.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            soma += numeros[i];
        }
        media = soma / 5;
        //Ordenação
        int indice;
        int elementoAtual;
        for (int i = 1; i < 5; i++) {
            elementoAtual = numeros[i];
            indice = i;
            while (indice > 0 && numeros[indice - 1] > elementoAtual) {
                numeros[indice] = numeros[indice - 1];
                indice--;
            }
            numeros[indice] = elementoAtual;
        }
        System.out.println("O maior numero e: " + numeros[4]);
        System.out.println("O menor numero e: " + numeros[0]);
        System.out.println("A média dos valor e: " + media);
        System.out.println("A soma dos valor e: " + soma);
    }

    public static void atividade2() {
        /*2- Soma de Matrizes: Escreva um programa 
        que receba duas matrizes bidimensionais de 
        mesmo tamanho e realize a soma entre elas, 
        armazenando o resultado em uma terceira matriz. 
        Em seguida, exiba a matriz resultante.*/

        Scanner ler = new Scanner(System.in);
        int matriz1[][] = new int[2][2];
        int matriz2[][] = new int[2][2];
        int result[][] = new int[2][2];

        for (int lin = 0; lin < 2; lin++) {
            for (int col = 0; col < 2; col++) {
                System.out.println("Entre com os elementos da primeira matriz: ");
                matriz1[lin][col] = ler.nextInt();
            }
        }
        for (int lin = 0; lin < 2; lin++) {
            for (int col = 0; col < 2; col++) {
                System.out.println("Entre com os elementos da segunda matriz: ");
                matriz2[lin][col] = ler.nextInt();
            }
        }
        for (int lin = 0; lin < 2; lin++) {
            for (int col = 0; col < 2; col++) {
                result[lin][col] = matriz1[lin][col] + matriz2[lin][col];
            }
        }
        for (int lin = 0; lin < 2; lin++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(result[lin][col] + " ");
            }
            System.out.println("");
        }
    }

    public static void atividade3() {
        /* Faça um programa que receba uma matriz bidimensional e 
        retorne sua matriz transposta. 
        A matriz transposta é obtida ao trocar as linhas pelas colunas.*/
        
        Scanner ler = new Scanner(System.in);

        int matriz[][] = new int[2][2];
        int matrizTransposta[][] = new int[2][2];

        for (int lin = 0; lin < 2; lin++) {
            for (int col = 0; col < 2; col++) {
                System.out.println("Entre com o valor da matriz da posicao [" 
                        + lin + "]" + "][" + col + "]: ");
                matriz[lin][col] = ler.nextInt();
            }
        }
        for (int lin = 0; lin < 2; lin++) {
            for (int col = 0; col < 2; col++) {
                matrizTransposta[col][lin] = matriz[lin][col];
            }
        }
        System.out.println("Matriz Transposta");
        for (int l = 0; l < 2; l++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(matrizTransposta[l][c] + " ");
            }
            System.out.println();
        }
    }

    public static void atividade4() {
        /* Escreva um programa que receba uma matriz bidimensional e 
        exiba o maior valor em cada linha.
        Por exemplo, para a matriz [[1, 2, 3], [4, 5, 6], [7, 8, 9]], 
        o programa deve exibir: 3, 6, 9.*/

        int[][] matriz = {
            {8, 2, 3},
            {4, 5, 2},
            {7, 1, 9}
        };
        for (int lin = 0; lin < matriz.length; lin++) {
            // Selection Sort para ordenar a linha
            for (int i = 0; i < matriz[lin].length - 1; i++) {
                int indice = i;
                for (int j = i + 1; j < matriz[lin].length; j++) {
                    if (matriz[lin][j] < matriz[lin][indice]) {
                        indice = j;
                    }
                }
                int temp = matriz[lin][i];
                matriz[lin][i] = matriz[lin][indice];
                matriz[lin][indice] = temp;
            }
            System.out.println("Maior valor na linha " + lin + ": "
                    + matriz[lin][matriz[lin].length - 1]);
        }
    }

    public static void atividade5() {
        /*Implemente um programa que realize a multiplicação entre duas 
        matrizes bidimensionais. O usuário deve informar as dimensões das 
        matrizes e seus elementos. 
        O programa deve exibir a matriz resultante da multiplicação.*/

        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o número de linhas da primeira matriz: ");
        int linhas1 = ler.nextInt();
        System.out.print("Digite o número de colunas da primeira matriz: ");
        int colunas1 = ler.nextInt();

        System.out.print("Digite o número de linhas da segunda matriz: ");
        int linhas2 = ler.nextInt();
        System.out.print("Digite o número de colunas da segunda matriz: ");
        int colunas2 = ler.nextInt();

        int[][] matriz1 = new int[linhas1][colunas1];
        System.out.println("Digite os elementos da primeira matriz:");
        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas1; j++) {
                matriz1[i][j] = ler.nextInt();
            }
        }

        int[][] matriz2 = new int[linhas2][colunas2];
        System.out.println("Digite os elementos da segunda matriz:");
        for (int i = 0; i < linhas2; i++) {
            for (int j = 0; j < colunas2; j++) {
                matriz2[i][j] = ler.nextInt();
            }
        }

        int[][] resultado = new int[linhas1][colunas2];
        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas2; j++) {
                for (int k = 0; k < colunas1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        System.out.println("Matriz resultante da multiplicação:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void atividade6() {
        /*Escreva um programa que receba uma matriz bidimensional e exiba a média 
       dos valores em cada coluna. Por exemplo, para a matriz 
       [[1, 2, 3], [4, 5, 6], [7, 8, 9]], o programa deve exibir: 4.0, 5.0, 6.0.
         */

        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o número de linhas da matriz: ");
        int linhas = ler.nextInt();
        System.out.print("Digite o número de colunas da matriz: ");
        int colunas = ler.nextInt();

        int[][] matriz = new int[linhas][colunas];
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = ler.nextInt();
            }
        }

        System.out.println("Médias das colunas:");
        for (int j = 0; j < colunas; j++) {
            double soma = 0;
            for (int i = 0; i < linhas; i++) {
                soma += matriz[i][j];
            }
            double media = soma / linhas;
            System.out.printf("%.1f ", media);
        }
    }
}
