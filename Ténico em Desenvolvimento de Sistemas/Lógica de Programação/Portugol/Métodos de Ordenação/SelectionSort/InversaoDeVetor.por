programa
{
	inclua biblioteca Util --> u	
	
	funcao inicio()
	{
		inteiro vetor[10]
          inteiro tamanho = 10
          inteiro j
          inteiro auxiliar
          inteiro indice
          inteiro vetorInverso[10]
          inteiro aux = 0
          inteiro casas = 10
          
//Preenchimento do vetor----------------------------------------
          para (inteiro i = 0; i < tamanho; i = i + 1) {
          	vetor[i]=u.sorteia(10, 50)
          }
//fim do preenchimento do vetor---------------------------------

//escrever o vetor original--------------------------------------
          escreva("Vetor original: ")
          para(inteiro i = 0;i<tamanho;i++){
          	escreva(vetor[i]," ")
          }
          escreva("\n")
//fim da escrita do vetor original
//ordenação	
		para(inteiro i=0; i < tamanho-1; i++){
			indice= i
			para(j=i+1; j<tamanho; j++){
				se (vetor[j] < vetor[indice]){
					indice = j          
				}
			}
			auxiliar = vetor[i]
			vetor[i] = vetor[indice]
			vetor[indice] = auxiliar
		}


//fim da ordenação

para(inteiro i = casas-1; i >= 0; i--){
			vetorInverso[aux] = vetor[i]
			aux++
		}
		
escreva("Vetor ordenado em ordem Crescente: ")
		para(inteiro i =0; i<tamanho;i++)
			escreva(vetor[i], " ")		

	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1140; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 7, 10, 5}-{tamanho, 8, 18, 7}-{auxiliar, 10, 18, 8}-{indice, 11, 18, 6}-{vetorInverso, 12, 18, 12};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */