programa
{
	inclua biblioteca Util --> u
	
	//Definir variáveis
	cadeia nome_status[100][2]
	real notas[100][4]
	inteiro recno = 0
	inteiro op = 1
	
	
	funcao inicio()
	{
		enquanto(op == 1){

			limpa()
			escreva("================= Cálculo da Média Final ==========================\n")

			escreva("Entre com o nome do aluno ", recno+1, ": \n")
			leia(nome_status[recno][0])
			para(inteiro n=0; n<3 ; n++){
				escreva("Entre com a nota ", n+1, ": ")
				leia(notas[recno][n])
				escreva("\n")		
			}
			escreva("Deseja continuar? (1-Sim / 2-Não) \n")
			leia(op)
			recno++
		}
		escreva("Deseja processar as notas e imprimir a tabela? 1-Sim  2-Não\n")
		leia(op)

		se(op == 1){
			para(inteiro c=0; c < recno ; c++){

				// Rotina de impressao
				// calcular Mf dos alunos
				// verificar o status baseado em Mf
			}
		}
		senao{
			limpa()
			escreva("Programa finalizado...")
			u.aguarde(3000)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 911; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */