programa
{
	
	// Aqui declaramos as variáveis de escopo global
	// status: APROVADO, REPROVADO e RECUPERAÇÃO
	real n1, n2, n3, mf
	cadeia status
	
	funcao inicio()
	{	

		/*
		 * 	Aqui vamos declarar variáveis de escopo local
		 * 	ou seja serão visíveis apenas nesta função
		 * 
		 */
		 
		// Entrada de dados
		
		escreva("===============================\n")
		escreva("||  Cálculo de Média Final   ||\n")
		escreva("===============================\n\n")
		
		escreva("Entre com a 1ª nota do aluno: \n")
		leia(n1)
		
		escreva("Entre com a 2ª nota do aluno: \n")
		leia(n2)
		
		escreva("Entre com a 3ª nota do aluno: \n")
		leia(n3)

		// Processamento da média final

		mf = (n1 + n2 + n3) / 3 

		// Análise do resultado da média final
		// Utilizando a estrutura condicional SE()

		/*
		se(mf >= 7.0){
			status = "APROVADO"
			 
		}
		se(mf < 5.0){
			status = "REPROVADO"
		}
		se(mf >= 5.0 e mf < 7.0){
			status = "RECUPERAÇÃO"
		}
		*/
		// Estrutura condicional SE SENAO
		/*
		se(mf >= 7.0){
			status = "APROVADO"
		}
		senao{
			se(mf < 5.0){
				status = "REPROVADO"
			}
			senao{
				status = "RECUPERAÇÃO"
			}
		}
		*/

		se(mf >= 7.0){
			status = "APROVADO"
		}
		senao se(mf < 5.0){
			status = "REPROVADO"
		}
		senao{
			status = "RECUPERAÇÂO"
		}
		
		escreva("O status do aluno é ", status, " com média final de ", mf)
	
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 518; 
 * @DOBRAMENTO-CODIGO = [39, 52];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {n1, 6, 6, 2}-{n2, 6, 10, 2}-{n3, 6, 14, 2}-{mf, 6, 18, 2};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz;
 */