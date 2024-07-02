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
        
        Fila f = new Fila();
        f.adicionar(10);
        f.adicionar(12);
        f.adicionar(30);
        f.mostrar();
        f.remover();
        f.mostrar();
    }
    
}
