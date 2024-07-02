programa
{
     inclua biblioteca Util --> u
     
     funcao inicio(){
     	inteiro vetor[15]
          inteiro impar=0
          inteiro j
          inteiro par=0
          inteiro casas=15
          
//-----------------Preenchimento do vetor----------------------------------------
          para (inteiro i = 0; i < casas; i = i + 1) {
          	vetor[i]=u.sorteia(10, 50)
          }
//---------------fim do preenchimento do vetor---------------------------------

//-------------escrever o vetor original--------------------------------------
          escreva("Vetor original: ")
          para(inteiro i = 0;i<casas;i++){
          	escreva(vetor[i]," ")
          }
          escreva("\n")
//-------------fim da escrita do vetor original--------------------------

//-----------ordenação----------------------------------------------------
		par=0
		impar=0
		para(inteiro i=0; i < casas-1; i++){
			casas=i
			para(j=i+1;j<casas;j++){
				se(vetor[j]){
					
				}
			}
		}
		
//---------------------fim da ordenação--------------------------------------------
escreva("Vetor ordenado em ordem Crescente: ")
		para(inteiro i =0; i<casas;i++)
			escreva(vetor[i], " ")		
     }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 965; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */