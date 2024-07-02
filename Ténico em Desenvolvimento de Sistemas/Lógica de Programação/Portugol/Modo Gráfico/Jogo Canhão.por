programa
{
	inclua biblioteca Mouse --> mo
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g
	inclua biblioteca Matematica --> m

	//Variáveis globais
	inteiro px = 20
	inteiro py = 555
	inteiro ang = 45
	inteiro x = 0
	inteiro y = 0
	real it [100]
	real xs [100]
	real ys [100]
	inteiro i = 0
	inteiro bal_x = 0 , bal_y = 0
	logico voo = falso
	logico novo = verdadeiro
	inteiro score = 0

	///Variaveis de calculo de trajetória da bala
	real ang_rad = 0.0
	real h_max = 0.0
	real dist_max = 0.0
	real temp = 0.0
	real gv = 9.81
	real v0 = 50.0
	//---------------------------------------------------------------------------

	////calculo para trajetoria da bala
	funcao trajetoria()
	{
		ang_rad = ang*(m.PI/180)
		h_max = m.potencia(v0,2.0)*m.potencia(m.seno(ang_rad),2.0)/(2*gv)
		dist_max = 2*m.potencia(v0, 2.0)*m.cosseno(ang_rad)*m.seno(ang_rad)/gv
		temp = 2*v0*m.seno(ang_rad)/gv

		real dt = temp/100
		real ti = 0.0
		real v0x = v0*m.cosseno(ang_rad)
		real v0y = v0*m.seno(ang_rad)

		para(inteiro c = 0; c<100 ; c++)
		{
			it[c] = ti
			ti = ti + dt
			xs[c] = v0x * it[c]
			ys[c] = v0y * it[c] - 0.5 * gv*m.potencia(it[c], 2.0)
			
		}
		
	}
	////desenho quadro 1
	funcao q1()
	{
		inteiro clrcont = g.criar_cor(137,65,18)
		inteiro clrfundo = g.criar_cor(211,182,144)
		g.definir_rotacao(0)
		g.definir_cor(clrfundo)
		g.desenhar_retangulo(5, 5, 590, 115, falso, verdadeiro)
		g.definir_cor(clrcont)
		g.desenhar_retangulo(5, 5, 590, 115, falso, falso)
		g.desenhar_retangulo(4, 4, 592, 117, falso, falso)
	}
	////desenho quadro 2
	funcao q2()
	{
		inteiro clrcont = g.criar_cor(120,19,29)
		g.definir_rotacao(0)
		g.definir_cor(clrcont)
		g.desenhar_retangulo(5, 125, 590, 270, falso, falso)
		g.desenhar_retangulo(4, 124, 592, 272, falso, falso)
	}
	////programar canhão
	funcao canhao(inteiro x, inteiro y)
	{
		inteiro clrcanhao = g.criar_cor(244,164,96)
		g.definir_rotacao(-ang)
		g.definir_cor(clrcanhao)
		g.desenhar_retangulo(x-20, y-5, 40, 10, falso, verdadeiro)
	}
	funcao eixo()
	{
		inteiro cor = g.criar_cor(0,0,0)
		g.definir_cor(cor)
		g.definir_rotacao(0)
      	g.desenhar_linha(5, py, px+580, py)
      	g.desenhar_linha(px, 124, px, 395)
	}
	funcao alvo (inteiro x, inteiro y)
	{
		inteiro cor_alvo = g.criar_cor(120, 10, 180)
		g.definir_cor(cor_alvo)
		g.definir_rotacao(0)
		g.desenhar_elipse(x-10, y-5, 20, 10, falso)
	}
	////programar bala
	funcao bala(inteiro x, inteiro y)
	{
		inteiro clrbala = g.criar_cor(119,136,153)
		g.definir_cor(clrbala)
		g.definir_rotacao(0)
		bal_x = x +xs[i]
		bal_y = y - ys[i]
		
		g.desenhar_elipse(bal_x-5, bal_y-5, 10, 10, verdadeiro)
	}
	////programar texto
	funcao texto()
	{
		inteiro clrtexto = g.criar_cor(0, 0, 0)
		g.definir_cor(clrtexto)
		g.definir_tamanho_texto(13.0)
		g.desenhar_texto(350, 15, "Ang = " +(ang)+"°"+" X = "+(px)+(" Y = "+(py)))
		g.desenhar_texto(350, 30, "Velocidade inicial (+/1) = "+v0)
		g.desenhar_texto(350, 45, "Tecla N: Novo alvo. Score: "+(score))
		g.desenhar_texto(350, 60, "Alvo: "+m.arredondar((x)+(y), 2))
		
		g.desenhar_texto(15, 15, "Rotação: R (anti-H)")
		g.desenhar_texto(15, 30, "Disparo: Barra-Espaço")
		g.desenhar_texto(15, 65, "Alcance horizontal...:"+m.arredondar(dist_max, 2))
		g.desenhar_texto(15, 80, "Tempo de Vôo.........:"+m.arredondar(temp, 2))
		g.desenhar_texto(15, 95, "Altura Maxima........:"+m.arredondar(h_max, 2))
	}
	////função de exibição
	funcao paint()
	{
		inteiro bege = g.criar_cor(224, 215, 175)
		g.definir_cor(bege)
		g.limpar()
		q1()
		q2()
		texto()
		eixo()
		canhao(px, py)
		bala(px, py)
		////Controle do Alvo
		se(novo==verdadeiro)
		{
			x=u.sorteia(200, 550)
			y=u.sorteia(135, 350)
			novo=falso
		}
		alvo(x,y)
		////nave

		se(((bal_x >= x-4 e (bal_x <= x+4))e((bal_y >= y-3) e (bal_y <= y+3))))
		{
			score++
			novo = verdadeiro
		}
		
		g.renderizar()
	}
	funcao ctrl()
	{
		//Movimentação
		se(t.tecla_pressionada(t.TECLA_SETA_DIREITA))
		{
			u.aguarde(5)
			px++
			
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA))
		{
			u.aguarde(5)
			px--
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ACIMA))
		{
			u.aguarde(5)
			py--
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO))
		{
			u.aguarde(5)
			py++
		}
		//Rotação
		se(t.tecla_pressionada(t.TECLA_R))
		{
			u.aguarde(5)
			ang++
		}
		se(t.tecla_pressionada(t.TECLA_T))
		{
			u.aguarde(5)
			ang--
		}
		se(t.tecla_pressionada(t.TECLA_ESPACO) ou voo == verdadeiro)
		{
			voo = verdadeiro
			i++
			u.aguarde(10)
			se(i >=100)
			{
				i = 0
				voo = falso
				
			}
		}
		////velocidade da bala
		se(t.tecla_pressionada(t.TECLA_ADICAO))
		{
			u.aguarde(100)
			v0++
		}
		se(t.tecla_pressionada(t.TECLA_SUBTRACAO))
		{
			u.aguarde(100)
			v0--
		}
		se(t.tecla_pressionada(t.TECLA_N))
		{
			u.aguarde(100)
			novo = verdadeiro
		}
		se(mo.botao_pressionado(mo.BOTAO_DIREITO))
		{
			u.aguarde(100)
			novo = verdadeiro
		}
		//Limites
		se(px>558)
		px = 558

		se(py>375)
		py=375

		se(px<4)
		px = 4

		se(py<130)
		py=130

		se(ang>90)
		ang = 90

		se(ang<0)
		ang = 0
	}
	///iniciação do game
	funcao inicio()
	{

		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(600, 400)
		g.definir_titulo_janela("Jogo do canhão")

		enquanto(nao t.tecla_pressionada(t.TECLA_ESC))
		{
			trajetoria()
			paint()
			ctrl()
		}

	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3125; 
 * @DOBRAMENTO-CODIGO = [33, 56, 68, 77, 84, 100, 160, 166, 171, 176, 182, 187, 197, 192, 205, 210, 215, 220];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */