/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wilian_g_cardoso
 */
public class Linha {
    private int qtdParadas = 0;
    private String nmLinha;
    
    //construtor
    public Linha(int qtdParadas, String nmLinha){
        this.qtdParadas = qtdParadas;
        this.nmLinha = nmLinha;
    }
    
    public Linha(){
        
    }

    public int getQtdParadas() {
        return qtdParadas;
    }

    public void setQtdParadas(int qtdParadas) {
        this.qtdParadas = qtdParadas;
    }

    public String getNmLinha() {
        return nmLinha;
    }

    public void setNmLinha(String nmLinha) {
        this.nmLinha = nmLinha;
    }
    
    
}


