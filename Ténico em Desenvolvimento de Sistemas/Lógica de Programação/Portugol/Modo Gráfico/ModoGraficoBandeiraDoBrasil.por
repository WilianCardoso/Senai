programa
{
     inclua biblioteca Graficos --> g

     funcao textos()
     {
          g.definir_cor(Graficos.COR_PRETO)
          g.definir_tamanho_texto(15.0)
          g.desenhar_texto(230, 190, "ORDEM E PROGRESSO")
     }

     funcao shapes()
     {
          inteiro pnts[4][2] = {
               {10, 200},
               {300, 10},
               {590, 200},
               {300, 390}
          }
          g.definir_cor(Graficos.COR_AMARELO)
          g.desenhar_poligono(pnts, verdadeiro)
          g.definir_cor(Graficos.COR_AZUL)
          g.desenhar_elipse(200, 100, 200, 200, verdadeiro)
          g.definir_cor(Graficos.COR_BRANCO)
          g.desenhar_retangulo(200, 190, 200, 15, falso, verdadeiro)

     }

     funcao desenhar(){
          g.definir_cor(Graficos.COR_VERDE)
          g.limpar()
          
          shapes()
          textos()
          
          g.renderizar()
     }

     funcao inicio()
     {
          g.iniciar_modo_grafico(verdadeiro)
          g.definir_dimensoes_janela(600, 400)
          g.definir_titulo_janela("Utilizando o Modo Gráfico")
          enquanto (verdadeiro) {
               desenhar()
          }
     }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 291; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {pnts, 14, 18, 4};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */