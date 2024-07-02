programa
{
	
	cadeia nome_status[5][2]
	real notas[5][3]
	
	funcao inicio()
	{
		para(inteiro lin = 0; lin < 5 ; lin++){
			//Movimentação das linhas
			escreva("\nEntre com o nome do aluno", lin+1,"\n")
			leia(nome_status[lin][0])
			
			//Movimentação das colunas
			para(inteiro col = 0; col <3 ; col++){
				escreva("Entre com a nota ", col+1, " do aluno ", lin+1, "\n")
				leia(notas[lin][col])
			}
			
			//Média do aluno
			notas[lin][2] = (notas[lin][0] + notas[lin][1] + notas[lin][2])  / 3

			//Outra forma
			/*
			  para(inteiro l=0 ; l=5 ; l++){
			  	real mf = 0.0

			  	para(inteiro c=0 ; c<3 ; c++){
			  		mf = mf +notas[l][c]
			  	}
			  	se(mf/3 >= 7.0) nome_status[l][1] = "APROVADO"
			  	senao se(mf/3 >= 5.0) nome_status[l][1] = "REPROVADO"
			  	senao nome_status[l][1] = "RECUPERAÇÃO"
			  }
			*/
			
			//laço que vai dar o Status dos alunos
			se(notas[lin][2] >= 7.0){
				nome_status[lin][1] = "APROVADO"
			}
			senao se(notas[lin][2] < 5.0){
					nome_status[lin][1] = "REPROVADO"
			}
			senao{
		 		nome_status[lin][1] = "RECUPERAÇÃO"
			}
		}
		
		//limpa tudo que vem antes
		limpa()
		
		//Mostra no console o status do ALuno
		escreva("===== Status dos alunos =====\n")
		para(inteiro lin = 0; lin < 5; lin++){
				//linhas de 0 á 5 //lin++ verifica o próximo
			escreva("\nAluno: ", nome_status[lin][0], " ele está: ", nome_status[lin][1])
		}							//linha-coluna
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 531; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {nome_status, 4, 8, 11}-{notas, 5, 6, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz;
 */