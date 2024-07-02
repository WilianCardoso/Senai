/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author wilian_g_cardoso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaLigada lista = new ListaLigada();
        System.out.println("Tamanho: "+lista.getTamanho());
        lista.adicionar("Gustavo");
        lista.adicionar("m");
        lista.adicionar("A");
        
        lista.remover("B");
        System.out.println(lista.getTamanho());
        System.out.println(lista.getPrimeiro().getValor());
        System.out.println(lista.getUltimo().getValor());
        System.out.println(lista.get(0).getValor());
        System.out.println(lista.get(1).getValor());
        System.out.println(lista.get(2).getValor());
    }
    
}
