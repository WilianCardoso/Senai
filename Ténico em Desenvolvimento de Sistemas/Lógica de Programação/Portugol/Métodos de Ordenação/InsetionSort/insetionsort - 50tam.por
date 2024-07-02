programa
{
     inclua biblioteca Util --> u

     inteiro vetor[50]
     inteiro tamanho = 50
     inteiro j
     inteiro elementoAtual
     inteiro indice

     funcao insertionSort()
     {
          para (inteiro i = 0; i < 50; i = i + 1) {
               elementoAtual = vetor[i]
               indice = i
               enquanto (indice > 0 e vetor[indice - 1] > elementoAtual) {
                    vetor[indice] = vetor[indice - 1]
                    indice = indice - 1
               }
               vetor[indice] = elementoAtual
          }
          escreva("Vetor ordenado Crescente: ")
          para (inteiro i = 0; i < tamanho; i = i + 1) {
               escreva(vetor[i], " ")
          }
          para (inteiro i = 0; i < 50; i = i + 1) {
               elementoAtual = vetor[i]
               indice = i
               enquanto (indice > 0 e vetor[indice - 1] < elementoAtual) {
                    vetor[indice] = vetor[indice - 1]
                    indice = indice - 1
               }
               vetor[indice] = elementoAtual
          }
          escreva("\nVetor ordenado Decrescente: ")
          para (inteiro i = 0; i < tamanho; i = i + 1) {
               escreva(vetor[i], " ")
          }
     }

     funcao inicio()
     {
          para (inteiro i = 0; i < tamanho; i = i + 1) {
               vetor[i] = u.sorteia(10, 50)
          }
          escreva("Vetor Original: ")
          para (inteiro i = 0; i < tamanho; i = i + 1) {
               escreva(vetor[i], " ")
          }
          escreva("\n")
          insertionSort()
     }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 912; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 5, 13, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */