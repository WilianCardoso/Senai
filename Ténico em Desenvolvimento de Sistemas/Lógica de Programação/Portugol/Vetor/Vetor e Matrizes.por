programa
{
	inclua biblioteca Matematica --> m
	
	//Váriaveis Globais
	cadeia nome[5]
	real notas[5][4]
	caracter parar
	
	
	funcao inicio()
	{
	parar = 'N'
	
		//------------ Entrada de dados -----------------------
		escreva("======= Cálculo da Média Final =======\n")
	enquanto{
		
	}
		para(inteiro linha=0 ; linha < 5 ; linha++){

			real soma = 0.0 
			
			escreva("Entre com o nome do ", linha+1,"º aluno: ")
			leia(nome[linha])
			
			para(inteiro coluna=0 ; coluna < 3 ; coluna++){
				escreva("\nEntre a nota ", coluna+1, " do aluno ", linha+1, ": ")
				leia(notas[linha][coluna])

			
				}
				//------------ Cálculo da Média Final -----------------------
							  	

				para(inteiro l=0 ; l<5 ; l++){
					real mf = 0.0

					para(inteiro c=0 ; c<3 ; c++){
			  		mf = mf +notas[l][c]
			  	}
			  	notas[l][3] = m.arredondar(mf/3, 2)

			  	se(notas[linha][2] >= 7.0){
				nome[linha] = "APROVADO"
			}
			senao se(notas[linha][2] < 5.0){
					nome[linha] = "REPROVADO"
			}
			senao{
		 		nome[linha] = "RECUPERAÇÃO"
			  	
		}
	}
}
	// ---------- Apresentação Tabela de Dados ---------------------
		
		escreva("====== Tabela de Dados ====== \n")

		para(inteiro linha=0 ; linha < 5 ; linha++){
			escreva(nome[linha], "\t")
			para(inteiro coluna=0 ; coluna < 4 ; coluna++){
				escreva(m.arredondar(notas[linha][coluna], 2), "\t")
			}
			escreva("\n")
		}

	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 280; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */