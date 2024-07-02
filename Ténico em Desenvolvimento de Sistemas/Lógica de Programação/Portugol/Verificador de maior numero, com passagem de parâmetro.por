/*
 
 Peça ao usuário 10 numeros e calcule quantos
 numeros estão acima de 5. Utilize uma funcao 
 para o calculo. Não utilize vetor.
 
 */

programa
{	
	inteiro verificado = 0
	funcao inteiro verificar(inteiro n ){
		se(n > 5){
			verificado++		
		}
		retorne verificado
	}
	
	funcao inicio()
	{
		inteiro numero, contador = 0, resultado

		faca{
			escreva("Entreo com o numero: ")
			leia(numero)
			resultado = verificar(numero)
			contador++
			limpa()
		} enquanto(contador <10)
		escreva(resultado," números são maiores que 5")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 537; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */