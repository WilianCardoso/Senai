programa
{
	inclua biblioteca Matematica --> m
	
	inteiro valor, c, d, u
	inteiro rc, rd, M  
	
	funcao inicio()
	{

		escreva("Entre com um número de três algarismos: ")
		leia(valor)

		

		c = valor / 100
		rc = valor - (c * 100)	
		d = rc / 10
		rd = rc - (d * 10)

		M = (rd * 100) + (d * 10) + c
		
		escreva("Este número ", valor, " é composto por ", M )
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 344; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */