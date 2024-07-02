programa
{		


	funcao inicio()
	{

	real v1, v2, v3, mn

		escreva("Entre com o 1º valor:")
		leia(v1)
		
		escreva("Entre com o 2º valor:")
		leia(v2)
		
		escreva("Entre com o 3º valor:")
		leia(v3)

		se(v1 > v2 e v1 > v3){
			mn = v1
		} senao se(v2 > v1 e v2 > v3){
			mn = v2
		} senao{
			mn = v3
		}
		escreva("\nO valor mais alto é:",mn)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 94; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */