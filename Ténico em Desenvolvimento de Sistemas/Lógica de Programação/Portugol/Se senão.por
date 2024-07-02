/*
 1 - Escreva um programa que pergunte a velocidade de um carro.
 */

programa
{
	
	funcao inicio()
	{	
		inteiro velocidade, multa
		
		escreva("Qual a sua velocidade? \n")
		leia(velocidade)
		limpa()
		se (velocidade>80){
			multa = (velocidade-80)*5			
		escreva("Você foi multado. Valor da multa R$ ",multa)			
		}senao{
			escreva("Dentro da velocidade permitida")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 105; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */