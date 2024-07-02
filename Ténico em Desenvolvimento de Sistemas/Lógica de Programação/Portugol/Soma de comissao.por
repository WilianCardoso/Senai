programa
{
	
	funcao inicio()
	{
		real cm, slb, vv, sl

		escreva("Entre com o Salário base:")
		leia(slb)
		
		escreva("Entre com o valor das vendas:")
		leia(vv)

		se(  vv >= 20000 e vv < 35000){
			  sl = slb + (vv * 0.012)
		}
		
		senao se(  vv >= 35000 e vv < 50000){
			  sl = slb + (vv * 0.015)
		}
		senao se(  vv >= 50000 e vv < 80000){
			  sl = slb + (vv * 0.018)
		}
		
		senao se(  vv > 80000){
			  sl = slb + (vv * 0.025)
		}
		senao{
			sl = slb
		}

		escreva("O salário é R$", sl)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 496; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */