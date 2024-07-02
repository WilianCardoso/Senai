/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package applocadora;

/**
 *
 * @author wilian_g_cardoso
 */
public class AppLocadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Gerenciando a frota de veiculos
        
        // Instanciando objetos
        
        Carro carro1 = new Carro("XPTO-45","VERDE");
        
//      carro1.modelo = "XPTO-35";
//      carro1.cor = "AZUL";
        carro1.setMotor("XT-2000"); 
        //tpCombustivel - 1= Gaso; 2= Alcool; 3 Flex
        carro1.setTpCombustivel(1);
        carro1.qtdCombustivel = 35.0f;
        carro1.avancar(5);
        
        
        carro1.printStatus();
        
        System.out.println("-----------------------------------------------");
        
        carro1.parar();
        carro1.qtdCombustivel = 15.0f;
        
        carro1.printStatus();
    }
    
}
