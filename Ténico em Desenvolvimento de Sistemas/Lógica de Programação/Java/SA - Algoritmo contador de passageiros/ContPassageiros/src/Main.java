import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author wilian_g_cardoso
 */
public class Main {

    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        Onibus on = new Onibus("098-WTF", 40, 0);
        Linha l1 = new Linha(6, "Rodoviaria - Seu Jorge");
        Viagem v1 = new Viagem("15/06", "14:00", "l1", "on");

        /*
        //Cont passg
        int qtdEmbarque;
        int qtdDesembarque;
        for(int i = 0; i < v1.getLinha().getQtdParadas(); i++){
            qtdEmbarque = Integer.parseInt(JOptionPane.showMessageDialog("Informe a quantidade de passageiros."));
            v1.getOnbus().setQtdAtual(qtdEmbarque);
            v1.addPassageiros(qtdEmbarque);
            if(v1.getLinha().getQtdParadas() != 0){
                qtdDesembarque = Integer.parseInt(JOptionPane.showMessageDialog("Informe a quantos passageiros desembarcaram."));
         */
        cadastroOnibus();
    }

    public static void Menu() {
        System.out.println(" ___________Cadastre sua Viagem_____________");
        System.out.println("|                                           |");
        System.out.println("|         1 - Cadastre o Onibus             |");
        System.out.println("|         2 - Cadastre a viagem             |");
        System.out.println("|         3 - Cadastre a linha              |");
        System.out.println("|         4 - Decorrer a viagem             |");
        System.out.println("|         4 - sair                          |");
        System.out.println("|___________________________________________|");
    }

    public static void cadastroOnibus() {
        System.err.println("Informe a placa do onibus:");
        System.out.print("ENTRADA:");
        String codPlaca = ler.next();
        System.err.println("Informe a capacidade maxima do onibus:");
        System.out.print("ENTRADA:");
        int capMax = ler.nextInt();
        System.out.println("Onibus cadastrado com sucesso!");
        
        Onibus on = new Onibus();
    }

    public static void cadastroViagem() {
        System.err.println("Informe a Data da viagem");
        System.out.print("Entrada:");
        String data = ler.next();
        System.err.println("Informe a hota da viagem");
        System.out.print("Entrada:");
        String hora = ler.next();
        System.err.println("Informe a linha da viagem");
        System.out.print("Entrada:");
        String linha = ler.next();
        System.err.println("Informe o onibus da viagem");
        System.out.print("Entrada:");
        String onibus = ler.next();
        
        Viagem vi = new Viagem();
    }

    public static void cadastroLinha() {
        Linha li = new Linha();
        
        System.err.println("Informe a linha");
        System.out.print("Entrada:");
        String linha = ler.next();
        System.err.println("Informe a qantidade de paradas");
        System.out.print("Entrada:");
        int qtdParadas = ler.nextInt();
        
    }
}
