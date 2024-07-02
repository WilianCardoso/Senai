programa
{
	
	funcao inicio()
	{
		real l1,l2,l3
		logico eq, es, tri

		escreva("Entre com o primeiro valor do primeiro lado: ")
		leia(l1)
		escreva("Entre com o segundo valor do segundo lado: ")
		leia(l2)
		escreva("Entre com o terceiro valor do terceiro lado: ")
		leia(l3)

		tri = (l1 < l2 + l3) e (l2 < l1 + l3) e (l3 < l2 + l1)
		escreva("Esses valores podem formar um triângulo? ",tri,"\n")
		eq = (l1 == l2) e (l2 == l3)
		escreva("O triângulo é Equilátero? ",eq)
		
		es = (l1 != l2) e (l2 != l3) e (l1 != l3)
		escreva("\nO triângulo é Escaleno? ", es)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 75; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */