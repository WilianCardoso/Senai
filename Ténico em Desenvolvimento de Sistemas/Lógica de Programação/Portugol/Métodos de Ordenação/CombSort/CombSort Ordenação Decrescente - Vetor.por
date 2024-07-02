programa
{

     funcao inicio()
     {
          cadeia nome[10], auxiliar2
          inteiro notas[10]
          inteiro tamanho = 10
          inteiro i
          inteiro j
          inteiro indice
          inteiro gap
          inteiro auxiliar
          real fator
          logico trocado
          
          para (i = 0; i < tamanho; i = i + 1) {
               escreva("\nEntre com o nome do aluno", i + 1, "\n")
               leia(nome[i])
               escreva("Entre com a nota ", i + 1, " do aluno ", i + 1, "\n")
               leia(notas[i])
          }
          escreva("Vetor Original: \n")
          para (i = 0; i < tamanho; i = i + 1) {
               escreva(nome[i], " ")
               escreva(notas[i], " ")
          }
//Ordenação-----------------------------------------------------	

		fator = 1.3
		trocado = verdadeiro
		gap = tamanho
		enquanto (gap > 1 ou trocado){
			gap = (gap / fator)
			se(gap < 1) {
				gap = 1
			}
			trocado = falso
			i = 0
			   enquanto (i + gap < tamanho) {
			   	se(notas[i] > notas[i + gap]){
			   		//troca os elementos
			   		auxiliar = notas[i]
			   		auxiliar2 = nome[i]
			   		
			   		notas[i] = notas[i + gap]
			   		nome[i] = nome[i + gap]
			   		
			   		notas[i + gap] = auxiliar
			   		nome[i + gap] = auxiliar2
			   		
			   		trocado = verdadeiro
			   	}
			   	i = i + 1
			   }		   
		}
		escreva("\nVetor Ordenado: \n")
		 para (i = 0; i < tamanho; i = i + 1) {
               escreva(nome[i], " ")
               escreva(notas[i], " ")
          }

     }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 69; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {nome, 6, 17, 4}-{notas, 7, 18, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */