programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g 
	

	inteiro bolaX = 0
	inteiro bolaY = 0
	inteiro v0=0
	
	funcao textos(){
		g.definir_cor(g.COR_PRETO)
		g.definir_tamanho_texto(20)
		g.desenhar_texto(20, 20, "Cordenada X: "+bolaX)
		g.desenhar_texto(200, 20, "Cordenada y: "+bolaY)
		g.desenhar_texto(400, 20, "Velocidade: "+v0)
	}
	funcao mover(){
		u.aguarde(5)
		se(t.tecla_pressionada(t.TECLA_SETA_DIREITA) ou t.tecla_pressionada(t.TECLA_D)){
			bolaX++
		}
		
		se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA) ou t.tecla_pressionada(t.TECLA_A)){
			bolaX--
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ACIMA) ou t.tecla_pressionada(t.TECLA_W)){
			bolaY--
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO) ou t.tecla_pressionada(t.TECLA_S)){
			bolaY++
		}
		
	
	}
	funcao vel(){
		u.aguarde(v0)
		se(t.tecla_pressionada(t.TECLA_SUBTRACAO)){
			v0++
			se( v0 > 100){
				v0=100
			}
		}
		u.aguarde(v0)
		se(t.tecla_pressionada(t.TECLA_ADICAO)){
			v0--
			se(v0 < 0){
				v0=0
			}
		}
	}
	funcao limite(){
		se(400 + bolaX > 770){
			bolaX=370
		}
		se(300 + bolaY >570){
			bolaY=270
		}
		se(400 + bolaX < 0){
			bolaX = -400
		}
		se(300 + bolaY < 0){
			bolaY = -300
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
		textos()
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
			vel()
			
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 162; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */