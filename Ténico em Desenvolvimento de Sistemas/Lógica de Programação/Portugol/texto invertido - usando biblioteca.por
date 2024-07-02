programa
{
	inclua biblioteca Texto --> texto
	funcao inicio()
	{
		cadeia texto,txt_invertido = ""
		inteiro tamanho
		
		escreva("Entre com um texto\n")
		leia(texto)

		tamanho = texto.numero_caracteres(texto)
		
		para(inteiro i = tamanho -1; i>=0; i--){

			txt_invertido = txt_invertido + texto.obter_caracter(texto,i)
		}
			escreva("O números de caracter é: ", tamanho,"\n")
			escreva("O texto ao contrário fica: ", txt_invertido)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 337; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {txt_invertido, 6, 15, 13}-{tamanho, 7, 10, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */