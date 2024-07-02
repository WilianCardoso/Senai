programa
{
     inclua biblioteca Util --> u
     const inteiro tam = 50

     inteiro vetor[tam]

     funcao inicio()
     {
          inteiro tamanho = tam
          inteiro aux
          inteiro i
          para (i = 0; i < tamanho; i = i + 1) {
               vetor[i] = u.sorteia(10, 50)
          }
          escreva("Vetor Original: ")
          para (i = 0; i < tamanho; i = i + 1) {
               escreva(vetor[i], " ")
          }
          escreva("\n")
          quickSort(vetor, 0, tam - 1)
          escreva("Vetor Ordenado em forma Crescente: ")
          para (i = 0; i < tamanho; i = i + 1) {
               escreva(vetor[i], " ")
          }
          escreva("\n")
          escreva("Vetor Ordenado em forma Decrescente: ")
          para (i = 0; i < tamanho; i = i + 1) {
               escreva(vetor[i], " ")
          }
     }

     funcao quickSort(inteiro vetor[], inteiro inicio, inteiro fim)
     {
          inteiro i
          inteiro j
          inteiro pivo
          inteiro aux
          i = inicio
          j = fim
          pivo = vetor[(inicio + fim) / 2]
          enquanto (i <= j) {
               enquanto (vetor[i] < pivo) {
                    i = i + 1
               }
               enquanto (vetor[j] > pivo) {
                    j = j - 1
               }
               se (i <= j) {
                    aux = vetor[i]
                    vetor[i] = vetor[j]
                    vetor[j] = aux
                    i = i + 1
                    j = j - 1
               }
          }
          se (j > inicio) {
               quickSort(vetor, inicio, j)
          }
          se (i < fim) {
               quickSort(vetor, i, fim)
          }
//------------------------------------------------------          
          enquanto (i <= j) {
               enquanto (vetor[i] > pivo) {
                    i = i + 1
               }
               enquanto (vetor[j] < pivo) {
                    j = j - 1
               }
               se (i <= j) {
                    aux = vetor[i]
                    vetor[i] = vetor[j]
                    vetor[j] = aux
                    i = i + 1
                    j = j - 1
               }
               se (j > inicio) {
                    quickSort(vetor, inicio, j)
               }
               se (i < fim) {
                    quickSort(vetor, i, fim)
               }
          }
     }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2468; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */