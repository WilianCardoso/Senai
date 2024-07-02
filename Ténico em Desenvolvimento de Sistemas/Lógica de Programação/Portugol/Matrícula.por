programa
{

	inteiro matricula, ano, semestre, d
		
	funcao inicio()
	{
		escreva("Entre com a matricula do aluno: ")
		leia(matricula)
		
		ano = matricula / 10000
		semestre = matricula / 1000 % 10
		d = matricula % 1000
		
		escreva("Ano: ", ano, " Semestre: " , semestre)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 267; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */