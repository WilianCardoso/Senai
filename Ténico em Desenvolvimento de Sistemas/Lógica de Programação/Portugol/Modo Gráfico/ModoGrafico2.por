programa
{
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g 

	inteiro bolaX = 0
	inteiro bolaY = 0
	
	funcao textos(){
		inteiro minhaCor = g.criar_cor(30, 100, 50)
		g.definir_cor(minhaCor)
		g.definir_tamanho_texto(30.0)
		g.desenhar_texto(20, 20, "TESTE DE USO DA FUNÇÃO DEENHAR TEXTO")
	}
	funcao mover(){
		se(t.tecla_pressionada(t.TECLA_SETA_DIREITA)){
			bolaX++
		}
		
		se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)){
			bolaX--
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ACIMA)){
			bolaY--
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO)){
			bolaY++
		}
		
	
	}
	funcao limite(){
		se(bolaX <= 0){
			bolaX=0
		}
	}
	funcao desenhar(){
		g.definir_cor(g.COR_BRANCO)
		g.limpar()
		
		//--------------------------

		//Inserir elementos na tela
		g.definir_cor(g.COR_AZUL)
		//g.desenhar_retangulo(200, 150, 200, 150, falso, verdadeiro)
					                                                               //ponto superior esquerdo --- X e Y	
		//g.definir_cor(g.COR_VERDE)
		g.desenhar_elipse(400+bolaX, 300+bolaY, 30, 30, verdadeiro)			                                                               
		
		//textos()
		
		//--------------------------
		g.renderizar()
	}
	
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800, 600)
		g.definir_titulo_janela("Utilizando o Modo Gráfico")
		enquanto(verdadeiro){
			limite()
			mover()
			desenhar()	
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1394; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */