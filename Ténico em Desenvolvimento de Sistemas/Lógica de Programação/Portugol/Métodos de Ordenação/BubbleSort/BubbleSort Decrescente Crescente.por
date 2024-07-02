programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro vetor[] = {1,5,6,9,7,10,598,218,55},tamanho=9, j, auxiliar

	// Preenchimento do Vetor-------------------------------------
		//para(inteiro i = 0; i < tamanho; i++){
			//vetor[i] = u.sorteia(10, 50)
		//}
		escreva("Vetor Original: ")
		para(inteiro i=0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
	//Ordenação---------------------------------------------------

		para(j = 1; j <= tamanho; j++){
		para(inteiro i = 0; i < tamanho - 1; i++){
			se (vetor[i] > vetor[i+1]){
				auxiliar = vetor[i]
				vetor[i] = vetor[i+1] 
				vetor[i+1] = auxiliar         
				}
			}
		}
		
		escreva("\nVetor Crescente: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\nVetor Decrescente: ")
		para(inteiro i = tamanho -1; i >=0; i--){
			escreva(vetor[i], " ")
		
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 108; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */