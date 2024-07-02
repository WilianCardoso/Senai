programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro vetor[10], tamanho =10, i, j, indice, gap, auxiliar
		real fator
		logico trocado

		// preenchimento do vetor
		para(i = 0; i<tamanho;i++){
			vetor[i]=u.sorteia(10, 50)
			
		}
//fim do preenchimento do vetor-------------------------------
	
//Vetor Original-----------------------------------------------
		escreva("Vetor Original: ")
		para(i =0; i<tamanho;i++){
			escreva(vetor[i], " ")	
		}
		escreva("\n")
//fim da escrita do vetor---------------------------------------	
	
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
			   	se(vetor[i] > vetor[i + gap]){
			   		//troca os elementos
			   		auxiliar = vetor[i]
			   		vetor[i] = vetor[i + gap]
			   		vetor[i + gap] = auxiliar
			   		trocado = verdadeiro
			   	}
			   	i = i + 1
			   }
		}
//fim da ordenação
		escreva("vetor ordenado: ")
			para(i = 0; i < tamanho; i++){
				escreva(vetor[i], " ")			
			}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 129; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 7, 10, 5}-{tamanho, 7, 21, 7}-{j, 7, 37, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */