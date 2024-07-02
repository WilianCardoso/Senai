programa
{
	
	funcao inicio()
	{
		inteiro n1=4, n2=5
		
//----------------------------------OP Lógico E------------------------------------------------------------------------------------------------		
	
	/*O operador lógico "e" requer sempre que ambos testes lógocos 
	  sejam verdadeiros*/

	  /*Teste lógico onde as duas comparações são verdadeiras, 
	  	então será executado o que está dentro do escreva.*/
		se(n1<n2 e n2>n1){
			escreva("Paula e Quésia estão felizes")
		}
		
	/*Teste Lógico onde a primeira comparação é falsa e a segunda é verdadeira
		então não ira executar o que está dentro do escreva.*/	
		se(n1>n2 e n2>n1){
			escreva("Paula e Quésia estão felizes")
		}
//--------------------------------- OP Lógico OU -------------------------------------------------------------------------------------
	
	/*Já o operador Lógico "ou" requer que apenas um dos testes seja verdadeiro.*/
		
		/*Aqui o que está dentro do escreva será executado, 
			pois um dos testes é verdadeiro*/
		se(n1>n2 ou n2>n1){
			escreva("\nPaula e Quésia estão felizes")
		}

		/*Já aqui ambos os testes são falsos,
			então não sera executado o que está dentro do escreva*/
		se(n1>n2 ou n2<n1){
			escreva("\nPaula e Quésia estão felizes")
		}
//----------------------------------OP Lógico NÃO------------------------------------------------------------------------------------------------		
		/*O operador lógico nao, é usado para inverter o valor de uma variável/teste lógico.*/

		/**/
		se(nao(n1>n2 e n2>n1)){
			escreva("\nPaula e Quésia estão felizes")
		}
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1488; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {n1, 6, 10, 2}-{n2, 6, 16, 2};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */