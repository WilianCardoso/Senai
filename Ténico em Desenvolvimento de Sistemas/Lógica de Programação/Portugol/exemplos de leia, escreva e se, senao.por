programa
{
	
	funcao inicio()
	{
	
	inteiro idade
	cadeia nome
	
		escreva("Informe seu nome ")
		leia(nome)
		
		escreva("Informe sua idade ")
		leia(idade)

		limpa()		
		escreva("O nome informado foi ", nome, " e a idade ",idade,"\n")
		
		se(idade<18){
			escreva("É menor de idade \n")
		}senao{
			escreva("É maior de idade \n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 248; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */