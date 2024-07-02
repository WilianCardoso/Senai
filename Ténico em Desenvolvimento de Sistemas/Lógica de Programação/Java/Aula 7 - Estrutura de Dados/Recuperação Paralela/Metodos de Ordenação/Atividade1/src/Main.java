/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
    1- Utilizando o “Insertion Sort” organize os seguintes dados:
        80,49,30,25,84,20,11,12,30,2,41,21,30,20,112.
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
         int vetor[] = {80,49,30,25,84,20,11,12,30,2,41,21,30,20,112};
         int elementoAtual, indice; 
         int tamanho = vetor.length;
         
         for (int i = 0; i < tamanho; i++) {
            elementoAtual = vetor[i];
            indice = i;
            while(indice > 0 && vetor[indice -1] > elementoAtual){
                vetor[indice] = vetor[indice -1];
                indice--;
            }
            vetor[indice] = elementoAtual;
        }
         System.out.print("Vetor Ordenado: ");
         for (int i = 0; i < tamanho; i++) {
             System.out.print(vetor[i]+" ");
        }
    }
}
