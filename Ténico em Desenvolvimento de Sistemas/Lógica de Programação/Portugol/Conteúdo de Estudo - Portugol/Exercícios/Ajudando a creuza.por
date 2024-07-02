programa
{
	inclua biblioteca Matematica --> m
	
	
	funcao creuza1(){
		
		inteiro ano_atual, data_nasc, idade

		escreva("Em que ano nós estamos? ")
		leia(ano_atual)
		escreva("\n")
		escreva("Em que ano eu nasci? ")
		leia(data_nasc)
		escreva("\n")
		idade = (ano_atual - data_nasc)
		escreva("Minha idade é ",idade)
	}
	funcao creuza2(){
		
		real dinheiro, conversao

		escreva("Quantos reais eu tenho? ")
		leia(dinheiro)
		
		conversao = dinheiro / 5.14
		escreva("Posso ter U$",m.arredondar(conversao, 2))
	}
	funcao creuza3(){
		
		real fahrenheit, celsius
		
		escreva("Entre com o valor de graus em fahrenheit\n")
		leia(fahrenheit)
		
		celsius = (fahrenheit - 32) * 5/9
		escreva("Convertendo fahrenheit para celsius, temos: ",m.arredondar(celsius, 1),"C°")
	}
	funcao creuza4(){
		
		real muamba, imposto
		
		escreva("Entre com o valor que deu todas as compras feitas nos EUA U$")
		leia(muamba)
		
		imposto = (muamba * 60) / 100
		escreva("O imposto será de U$",imposto)
	}
	funcao creuza5(){
		
		real valor, vl_final, vl_juro, vl_parcela
		inteiro parcelas

		escreva("Qual o valor do empréstimo?\n R$")
		leia(valor)
		
		escreva("Irá parcelar em quantas vezes?\n ")
		leia(parcelas)
		
		vl_juro = (valor / parcelas) * 0.2
		
		vl_parcela = (valor / parcelas) + vl_juro
		
		vl_final = valor * 0.2
		
		vl_final = valor + vl_final 
		
		escreva("O valor de cada parcela será de: R$",vl_parcela," E o valor total com juros será de R$",vl_final)
	}
	funcao inicio()
	{
		//creuza1()
		//creuza2()
		//creuza3()
		//creuza4()
		//creuza5()
	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 71; 
 * @DOBRAMENTO-CODIGO = [5, 18, 28, 38, 48];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {valor, 51, 7, 5}-{vl_final, 51, 14, 8}-{parcelas, 52, 10, 8};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */