programa
{
	inclua biblioteca Matematica --> m
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g 
	

	inteiro bolaX = 0
	inteiro bolaY = 0
	inteiro reactX = 0
	inteiro reactY = 0
	inteiro r = 45
	logico eixo2 = falso 
	
	inteiro ptx = 0 

	//Vetores para guardar as cordenadas da trajetória
	real it[100]
	real xs[100]
	real ys[100]
	
	//Variáveis do lançamento obliquo
	real v0=50.0
	real gv = 9.81
	real h_max = 0.0 
	real temp = 0.0 
	real dist_max = 0.0
	real ang_rad = 0.0
	logico emVoo = falso
	

	
	
	funcao textos(){
		g.definir_cor(g.COR_PRETO)
		g.definir_tamanho_texto(15.0)
		g.desenhar_texto(450, 30, "Cordenada Y: "+reactY)
		g.desenhar_texto(450, 10, "Cordenada X: "+reactX)
		g.desenhar_texto(640, 30, "Velocidade: "+v0)
		g.desenhar_texto(640, 10, "Ang (+ / -) = "+r+"°")
		g.desenhar_texto(20, 10, "Rotação: T (anti-H) R(H)")
		g.desenhar_texto(20, 30, "Disparo: Barra-Espaço")
		g.desenhar_texto(20, 50, "Alcance horizontal...:"+m.arredondar(dist_max, 2))
		g.desenhar_texto(20, 70, "Tempo de Vôo.........:"+m.arredondar(temp, 2))
		g.desenhar_texto(20, 90, "Altura Maxima........:"+m.arredondar(h_max, 2))
	}
	funcao mover(){
		
		se(t.tecla_pressionada(t.TECLA_SETA_DIREITA) ou t.tecla_pressionada(t.TECLA_D)){
			u.aguarde(5)
			reactX++
			
		}
		
		se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA) ou t.tecla_pressionada(t.TECLA_A)){
			u.aguarde(5)
			reactX--
			
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ACIMA) ou t.tecla_pressionada(t.TECLA_W)){
			u.aguarde(5)
			reactY--
			
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO) ou t.tecla_pressionada(t.TECLA_S)){
			u.aguarde(5)
			reactY++
		}
		se(t.tecla_pressionada(t.TECLA_ESPACO) ou emVoo == verdadeiro){
			u.aguarde(10)
			emVoo = verdadeiro
			ptx++
			se(ptx >=100){
				ptx = 0
				emVoo = falso
			}
			
		}
	}
	funcao trajetoria(){
		
	// Fórmulas utilizadas no programam
	
		ang_rad = (m.PI/180)
	// Altura máxima 
		h_max = m.potencia(v0, 2.0)*m.potencia(m.seno(ang_rad),2.0)/(2*gv)
	
	//Alcance horizontal 
		dist_max = m.potencia(v0,2.0)*m.cosseno(ang_rad)*m.seno(ang_rad)/gv

	// Tempo Total
		temp = 2*v0*m.seno(ang_rad)/gv

		real dt = temp/100
		real ti = 0.0 // -> Tempo incial
		real v0x = v0*m.cosseno(ang_rad)
		real v0y = v0*m.seno(ang_rad)

		para(inteiro c=0;  c<100; c++){
			it[c] = ti 
			ti = ti + dt
			xs[c] = v0x * it[c]
			ys[c] = v0y * it[c]-0.5 * gv * m.potencia(it[c], 2.0) 
		}
	}
	funcao vel(){
		
		se(t.tecla_pressionada(t.TECLA_SUBTRACAO)){
			u.aguarde(v0)
			v0--
			se(v0 >=100.0){
				v0=99.0
			}
		}
		
		se(t.tecla_pressionada(t.TECLA_ADICAO)){
			u.aguarde(v0)
			v0++
			se(v0 <0.0){
				v0 = 1.0
			}
		}
	}
	funcao limite(){
		se(400 + reactX > 800){
			reactX=400
		}
		se(300 + reactY >600){
			reactY=300
		}
		se(400 + reactX < 0){
			reactX = -400
		}
		se(300 + reactY < 0){
			reactY = -300
		}
	}
	funcao bola(inteiro x, inteiro y){
		g.definir_cor(g.COR_AZUL)
          g.desenhar_elipse(bolaX-10,bolaY-10, 20, 20, verdadeiro)
          bolaX = x + xs[ptx]
		bolaY = y - ys[ptx]
	}
	funcao react(inteiro x, inteiro y, inteiro r){
		 g.definir_rotacao(r)
		se(t.tecla_pressionada(t.TECLA_R)){
			r--
		}
		g.definir_rotacao(r)
		se(t.tecla_pressionada(t.TECLA_T)){
			r++
		}	
		g.definir_cor(g.COR_VERDE)
		g.desenhar_retangulo(x-30 + reactX, y-12 + reactY, 60, 24, falso, verdadeiro)

		g.definir_rotacao(0)
	}
	funcao girar(){
		g.definir_rotacao(r)
		se(t.tecla_pressionada(t.TECLA_R)){
			u.aguarde(5)
			r--
		}
		g.definir_rotacao(r)
		se(t.tecla_pressionada(t.TECLA_T)){
			u.aguarde(5)
			r++
		}
	}
	funcao eixo(){
		
		g.definir_cor(g.COR_PRETO)
		g.definir_rotacao(0)
		
		faca {
			g.desenhar_linha(reactX+370, 600, reactX+370, 0)		
			g.desenhar_linha(0, reactY+288, 800, reactY+288)	
		}enquanto(eixo2)
	}
	funcao desenhar(){
		
		g.definir_cor(g.COR_BRANCO)
		g.limpar()
		//--------------------------
		//Inserir elementos na tela
          eixo()
		react(370, 288, r)
		bola(bolaX,bolaY)
		textos()
		//--------------------------
		g.renderizar()
	}
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800, 600)
		g.definir_titulo_janela("Utilizando o Modo Gráfico")
		enquanto(verdadeiro){
			limite()
			bola(bolaX, bolaY)
			trajetoria()
			mover()
			desenhar()	
			vel()
			girar()
			eixo()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 236; 
 * @DOBRAMENTO-CODIGO = [80, 106, 125, 124, 144, 170];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */