programa
{
	
	 
	inteiro dia, mes, ano 
	inteiro data
	
	funcao inicio()
	{

		escreva("Entre com a data no formato DDMMAA: ")
		leia(data)

		dia = data / 10000
		mes = data / 100 % 100
		ano = data % 100

		escreva("A data ao contrária fica ", ano, "/" , mes, "/", dia)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 206; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */