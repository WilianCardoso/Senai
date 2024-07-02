/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
 /*
   5- Dada uma fila de inteiros, escreva um programa que exclua todos os números negativos.

 */
/**
 *
 * @author gabriel_piske / julio_busarello / wilian_cardoso
 */
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Criando uma fila
        Queue<Integer> fila = new LinkedList<>();

        // Adicionando elementos à fila
        fila.add(10);
        fila.add(20);
        fila.add(30);

        // Exibindo a fila
        System.out.println("Fila: " + fila);

        // Removendo e exibindo o primeiro elemento da fila
        int primeiroElemento = fila.remove();
        System.out.println("Primeiro elemento removido: " + primeiroElemento);

        // Exibindo a fila após remoção
        System.out.println("Fila após remoção: " + fila);

        // Adicionando um elemento à fila
        fila.add(40);

        // Exibindo a fila após adição
        System.out.println("Fila após adição: " + fila);

        // Verificando se a fila está vazia
        boolean estaVazia = fila.isEmpty();
        System.out.println("A fila está vazia? " + estaVazia);

        // Obtendo o tamanho da fila
        int tamanhoDaFila = fila.size();
        System.out.println("Tamanho da fila: " + tamanhoDaFila);
    }
}
