/*
 1- Escreva um software que solicite 2 números
 e realze os seguintes cálculos
 	- Subtração
 	- Adição
 	- Multiplicação
 	- Divisão
 	- Média
 	- Porcentagem 

 	Faça o uuário pedir a operação e realize somente o calculo dela
*/
 
programa
{

	
	funcao inicio()
	{
		inteiro numero1, numero2, result, operacao
		
		escreva("Informe o primeiro número: ")
		leia(numero1)
		
		escreva("Informe o segundo número: ")
		leia(numero2)
		
		escreva("informe a operação que deseja realizar\n")
		escreva("======================================\n")
		escreva("|              Adição: 0             |\n")
		escreva("|              Subtração: 1          |\n")
		escreva("|              Multiplicação: 2      |\n")
		escreva("|              Divisão: 3            |\n")
		escreva("|              Média: 4              |\n")
		escreva("======================================\n")
		leia(operacao)
		limpa()
		
		se(operacao == 0){
			result = numero1 + numero2
			escreva("O resultado da soma foi: ", result,"\n")
		} senao se(operacao == 1){
			result = numero1 - numero2
			escreva("O resultado da subtração foi: ", result,"\n")			
		} senao se(operacao == 2){
			result = numero1 * numero2
			escreva("O resultado da multiplicação foi: ", result,"\n")	
		} senao se(operacao == 3){
			result = numero1 / numero2
			escreva("O resultado da divisão foi: ", result,"\n")
		} senao se(operacao == 4){
			result = (numero1 + numero2) / 2
			escreva("O resultado da média é: ", result)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1012; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */