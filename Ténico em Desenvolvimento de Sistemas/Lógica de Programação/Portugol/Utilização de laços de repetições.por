programa
{
	
	funcao inicio()
	{
		inteiro l1 = 0, l2 = 0, l3 = 0
		cadeia status
		
		escreva("valor 1:")
		leia(l1)
		
		escreva("valor 2:")
		leia(l2)
		
		escreva("valor 3:")
		leia(l3)

		se(l1 > l2 e l1 > l3){
			se(l1 < l2 + l3){
				escreva("Possivel")
				status = "Possivel"
			}
			senao{
				escreva("Impossivel")
				status = "Impossivel"
			}
		}
		senao se(l2 > l1 e l2 > l3){
			se(l2 < l1 + l3){
				escreva("Possivel")
				status = "Possivel"
			}
			senao{
				escreva("Impossivel")
				status = "Impossivel"
			}
		}
		senao{
			se(l3 < l2 + l1){
				escreva("Possivel")
				status = "Possivel"
			}
		}

		//Verificar qual tipo de triâgulo

		se(status == "Possivel"){
			se(l1 == l2 e l2 == l3){
				escreva("Triângulo Equilátero")
			}
			senao se(l1 == l2 ou l2 == l3 ou l1 == l3){
				escreva("Isósceles")
			}
			senao{
				escreva("Escaleno")
			}
			
		}
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 874; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */