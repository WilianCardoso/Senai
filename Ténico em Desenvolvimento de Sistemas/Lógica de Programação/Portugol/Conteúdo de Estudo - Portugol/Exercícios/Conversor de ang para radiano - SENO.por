programa
{
	inclua biblioteca Matematica --> u
	
	
	funcao inicio()
	{
	real ang, resultado, PI = 3.141592653589793

		//solicitação em graus
		escreva("Informe um angulo: ")
		leia(ang)
		
		//converasao para rad
		ang = ang * PI / 180
		
		//calcula o seno do ang
		resultado = u.seno(ang)

		//Exibe o resultado
		escreva("O seno de ", ang, " é: ", resultado)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 86; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {ang, 8, 6, 3};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */