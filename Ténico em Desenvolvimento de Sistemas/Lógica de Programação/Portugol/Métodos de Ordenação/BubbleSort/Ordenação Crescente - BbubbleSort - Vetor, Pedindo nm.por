programa
{

     funcao inicio()
     {
          inteiro nm[3]
          inteiro tamanho = 3
          inteiro i
          inteiro j
          inteiro auxiliar
          
          para (i = 0; i < tamanho; i = i + 1) {
               escreva("\nEntre com o número ", i + 1, "\n")
               leia(nm[i])
          }
          escreva("Vetor Original: \n")
          para (i = 0; i < tamanho; i = i + 1) {
               escreva(nm[i], " ")
          }
//Ordenação----------------------------------------------------

		para(j = 1; j <= tamanho; j++){
		para(i = 0; i < tamanho - 1; i++){
			se (nm[i] > nm[i+1]){
				auxiliar = nm[i]
				nm[i] = nm[i+1] 
				nm[i+1] = auxiliar         
				}
			}
		}
		escreva("\nVetor ordenado: \n")
          para (i = 0; i < tamanho; i = i + 1) {
               escreva(nm[i], " ")
          }		               
          }
     }
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 734; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */