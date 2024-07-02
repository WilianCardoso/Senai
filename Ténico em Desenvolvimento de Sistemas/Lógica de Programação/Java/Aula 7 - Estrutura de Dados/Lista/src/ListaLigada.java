/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wilian_g_cardoso
 */
public class ListaLigada {

    private Elemento primeiro;
    private Elemento ultimo;
    private int tamanho;

    public ListaLigada() {
        this.tamanho = 0;
    }

    public Elemento getPrimeiro() {
        return primeiro;
    }

    public setPrimeiro(Elemento primeiro) {
        this.primeiro = primeiro;
    }

    public Elemento getUltimo(Elemento ultimo) {
        return ultimo;
    }

    public Elemento setUltimo(Elemento ultimo) {
        return ultimo = ultimo;
    }
    
    public void getTamanho(){
        this.tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionar(String novoValor) {
        Elemento novoElemento = new Elemento(novoValor);
        //na primeira execucao ele executa isso
        if (this.primeiro == null && this.ultimo == null) {
            primeiro = novoElemento;
            ultimo = novoElemento;
        } else {// quando ja tem cadastro
            this.ultimo.setProximo(novoElemento);
            this.ultimo = novoElemento;
        }
        this.tamanho++;
    }

    public void remover(String novoValor) {

    }

    public Elemento get(int posicao) {
        Elemento atual = this.primeiro;
        for (int i = 0; < posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }// i numeros e atual os espaços
        return atual;
    }
}
