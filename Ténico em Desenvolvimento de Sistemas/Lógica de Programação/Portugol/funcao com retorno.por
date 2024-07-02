/*
 Escreva uma função que receba uma lista
 */

programa
{
		funcao inteiro media(inteiro n1, inteiro n2, inteiro n3, inteiro n4, inteiro n5){
			inteiro media = 0
			media = (n1 + n2 + n3 + n4 + n5) / 5
			//escreva("Média do números é ",media)
			retorne media
		}
	
	funcao inicio()
	{
		inteiro numero1, numero2, numero3, numero4, numero5, media2
		
		escreva("Informe o primeiro número: ")
		leia(numero1)
		escreva("Informe o segundo número: ")
		leia(numero2)
		escreva("Informe o terceiro número ")
		leia(numero3)
		escreva("Informe o quarto número: ")
		leia(numero4)
		escreva("Informe o quinto número: ")
		leia(numero5)
		limpa()
		media2 = media(numero1, numero2, numero3, numero4, numero5) / 5

		escreva("Média é ",media2)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 398; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */