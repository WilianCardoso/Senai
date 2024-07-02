programa
{
	
inclua biblioteca Util --> u
	const inteiro tamanhoV=5

	funcao merge(inteiro vetor[], inteiro inicio, inteiro fim)
	{
		inteiro meio, i,j,k, auxiliar[tamanhoV]

		//divide o vetor no meio
		se (inicio<fim){
			meio = (inicio+fim)/2
			merge(vetor,inicio,meio)
			merge(vetor,meio+1,fim)
			i=inicio
			j=meio+1
			k=inicio
			enquanto(i<=meio e j<=fim){
				se (vetor[i]<vetor[j]){
					auxiliar[k]= vetor[i]
					i++
				}senao{
					auxiliar[k] = vetor[j]
					j++
				}
				k++			
			}	
			enquanto(i<=meio){
			auxiliar[k] = vetor [i]
				i++
				k++
			}
			enquanto(j<=fim){
				auxiliar[k] = vetor[j]
				j++
				k++
			}
			para(i=inicio; i <=fim;i++){
				vetor[i]=auxiliar[i]
			}
		}
	}
	funcao inicio()
	{
		inteiro vetor[tamanhoV]
		inteiro tamanho=tamanhoV,i

	// Preenchimento do vetor
		 para (i = 0; i < tamanho; i = i + 1) {
               escreva("\nEntre com o número ", i + 1, "\n")
               leia(vetor[i])
          }
//Fim, do preenchimento do vetor
//escrever o vetor Original
		escreva("Vetor original: ")
		para (i=0;i<tamanho;i++){
			escreva(vetor[i], " ")		
		}
		escreva("\n")
	
//fim da escrita do vetor Original
//Ordenação
	merge(vetor,0,tamanhoV-1)
	
	escreva("Vetor Binário: ")
	para(i=0; i < tamanho; i++){
		inteiro numero = vetor[i]
		inteiro binario[tamanhoV * 8]
		inteiro indice = tamanhoV * 8-1

		enquanto(numero > 8){
			binario[indice] = numero % 2
			numero = numero / 2
			indice --
	}
	para(inteiro j = indice + 1; j < tamanhoV * 8; j++){
		escreva(binario[j])
	}
}	
//Fim ordenação
	escreva("\nVetor ordenado: ")
		para(i=0; i<tamanho;i++){
			escreva(vetor[i], " ")
				
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1563; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */