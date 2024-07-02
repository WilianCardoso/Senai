programa
{
	
	funcao inicio()
	{
		inteiro codigo, digitoV, s, a, b, c, d, f

		escreva("Entre com o código: ")
		leia(codigo)
		
		a = codigo / 10000
		b = codigo / 1000 % 10
		c = codigo / 100 % 10
		d = codigo / 10 % 10
		f = codigo % 10

		s = (6*a) + (5*b) + (4*c) + (3*d) + (2*f)
		digitoV = s % 7

		escreva(digitoV)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 327; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */