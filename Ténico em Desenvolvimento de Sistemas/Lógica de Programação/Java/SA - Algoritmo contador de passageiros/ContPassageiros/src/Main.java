
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author wilian_g_cardoso
 */
public class Main {

    private static ArrayList<Linha> linhas = new ArrayList<>();
    private static ArrayList<Onibus> onibusList = new ArrayList<>();
    private static ArrayList<Viagem> viagens = new ArrayList<>();
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
        int op = 0;

        do {
            System.out.println(" ___________Cadastre sua Viagem_____________");
            System.out.println("|                                           |");
            System.out.println("|         1 - Cadastre o Onibus             |");
            System.out.println("|         2 - Cadastre a viagem             |");
            System.out.println("|         3 - Cadastre a linha              |");
            System.out.println("|         4 - Exibir dados                  |");
            System.out.println("|         5 - sair                          |");
            System.out.println("|___________________________________________|");

            switch (op) {
                case 1:
                    cadastroOnibus();
                    break;
                case 2:
                    cadastroViagem();
                    break;
                case 3:
                    cadastroLinha();
                    break;
                case 4:
                    exibirDados();
                case 5:
                    System.out.println("Saindo...");
                default:
                    throw new AssertionError();
            }
        } while (op != 5);

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
        System.out.print("Data da Viagem (dd/MM/yyyy): ");
        String data = ler.nextLine();
        System.out.print("Hora da Viagem (HH:mm): ");
        String hora = ler.nextLine();
        System.out.print("Nome da Linha: ");
        String nmLinha = ler.nextLine();
        Linha linha = buscarLinha(nmLinha);
        if (linha == null) {
            System.out.println("Linha não encontrada!");
            return;
        }
        System.err.println("Informe a placa do onibus da viagem");
        String codPlaca = ler.nextLine();
        Onibus onibus = buscarOnibus(codPlaca);
        if (onibus == null) {
            System.out.println("Onibus não encontrado!");
            return;
        }

        Viagem viagem = new Viagem(data, hora, nmLinha, nmLinha);
        viagens.add(viagem);
        linhas.add(linha);
        System.out.println("Viagem cadastrada com sucesso!");

    }

    private static Onibus buscarOnibus(String codPlaca) {
        for (Onibus onibus : onibusList) {
            if (onibus.getCodPlaca().equalsIgnoreCase(codPlaca)) {
                return onibus;
            }
        }
        return null;
    }

    private static Linha buscarLinha(String nmLinha) {
        for (Linha linha : linhas) {
            if (linha.getNmLinha().equalsIgnoreCase(nmLinha)) {
                return linha;
            }
        }
        return null;
    }

    public static void cadastroLinha() {
        Linha li = new Linha();

        System.err.println("Informe a linha");
        System.out.print("Entrada:");
        String nmLinha = ler.nextLine();
        System.err.println("Informe a qantidade de paradas");
        System.out.print("Entrada:");
        int qtdParadas = ler.nextInt();
        
        Linha linha = new Linha(qtdParadas, nmLinha);
        linhas.add(linha);
        System.out.print("Sua linha foi cadastrada com Sucesso!");
    }

    private static void exibirDados() {
        System.out.println("Linhas:");
        for (Linha linha : linhas) {
            System.out.println("Nome: " + linha.getNmLinha() + ", Paradas: " + linha.getQtdParadas());
            for (Viagem viagem : linha.getViagens() ) {
                System.out.println("  Viagem: " + viagem.getData() + " " + viagem.getHora() + ", Ônibus: " + viagem.getOnibus());
            }
        }

        System.out.println("Ônibus:");
        for (Onibus onibus : onibusList) {
            System.out.println("Placa: " + onibus.getCodPlaca() + ", Capacidade Máxima: " + onibus.getCapMax() + ", Passageiros Transportados: " + onibus.getQtdPassag());
        }
    }
}
