
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal para cadastro de viagens de ônibus.
 *
 * @author wilian_g_cardoso
 */
public class Main {

    private static ArrayList<Onibus> onibusList = new ArrayList<>();
    private static ArrayList<Linha> linhas = new ArrayList<>();
    private static ArrayList<Viagem> viagens = new ArrayList<>();
    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        boolean sair = false;
        do {
            System.out.println(" ___________Cadastre sua Viagem_____________");
            System.out.println("|                                           |");
            System.out.println("|         1 - Cadastre o Onibus             |");
            System.out.println("|         2 - Cadastre a viagem             |");
            System.out.println("|         3 - Cadastre a linha              |");
            System.out.println("|         4 - Exibir dados                  |");
            System.out.println("|         5 - Decorrer Viagem               |");
            System.out.println("|         6 - sair                          |");
            System.out.println("|___________________________________________|");
            System.out.print("Entrada: ");
            int op = ler.nextInt();
            ler.nextLine(); // Consumir nova linha
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
                    break;
                case 5:
                    decorrerViagem();
                    break;
                case 6:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!sair);
    }

    public static void cadastroOnibus() {
        System.out.println("Informe a placa do onibus:");
        System.out.print("ENTRADA: ");
        String codPlaca = ler.next();
        System.out.println("Informe a capacidade maxima do onibus:");
        System.out.print("ENTRADA: ");
        int capMax = ler.nextInt();
        System.out.println("Onibus cadastrado com sucesso!");

        Onibus onibus = new Onibus(codPlaca, capMax, 0);
        onibusList.add(onibus);
    }

    public static void cadastroViagem() {
        System.out.print("Data da Viagem: ");
        String data = ler.next();
        System.out.print("Hora da Viagem: ");
        String hora = ler.next();
        String nmLinha = ler.nextLine();
        System.out.print("Nome da Linha: ");
        nmLinha = ler.nextLine();
        Linha linha = buscarLinha(nmLinha);
        if (linha == null) {
            System.out.println("Linha nao encontrada!");
            return;
        }
        System.err.println("Informe a placa do onibus da viagem");
        System.out.print("ENTRADA:");
        String codPlaca = ler.next();
        Onibus onibus = buscarOnibus(codPlaca);
        if (onibus == null) {
            System.out.println("Onibus nao encontrado!");
            return;
        }

        Viagem viagem = new Viagem(data, hora, nmLinha, codPlaca);
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
        System.out.println("Informe o nome da linha:");
        System.out.print("Entrada: ");
        String nmLinha = ler.nextLine();

        System.out.println("Informe a quantidade de paradas:");
        System.out.print("Entrada: ");
        int qtdParadas = ler.nextInt();

        Linha linha = new Linha(qtdParadas, nmLinha);
        linhas.add(linha);
        System.out.println("Sua linha foi cadastrada com sucesso!");
    }

        public static void decorrerViagem() throws IOException {
        System.out.print("Informe a placa do onibus da viagem a decorrer: ");
        String codPlaca = ler.next();
        
        Onibus onibus = buscarOnibus(codPlaca);
        if (onibus == null) {
            System.out.println("Onibus nao encontrado!");
            return;
        }

        System.out.print("Informe o nome da linha da viagem: ");
        String nmLinha = ler.next();
        Linha linha = buscarLinha(nmLinha);
        if (linha == null) {
            System.out.println("Linha nao encontrada!");
            return;
        }

        System.out.print("Informe o numero de passageiros embarcando: ");
        int qtdEmbarque = ler.nextInt();

        if (qtdEmbarque > onibus.getCapMax() - onibus.getQtdPassag()) {
            System.out.println("Numero de passageiros excede a capacidade maxima do onibus!");
            return;
        }

        onibus.setQtdPassag(onibus.getQtdPassag() + qtdEmbarque);
        onibus.setCapAtual(onibus.getCapMax() - onibus.getQtdPassag());

        FileWriter arquivo = new FileWriter("registro.txt", true);
        PrintWriter gravador = new PrintWriter(arquivo);

        gravador.println("Inicio da viagem com onibus de placa: " + onibus.getCodPlaca());
        gravador.println("Linha: " + linha.getNmLinha());
        gravador.println("Passageiros embarcados: " + qtdEmbarque);
        gravador.println("========================================");

        for (int parada = 1; parada <= linha.getQtdParadas(); parada++) {
            System.out.print("Informe o número de passageiros desembarcando na parada " + parada + ": ");
            int qtdDesembarque = ler.nextInt();

            if (qtdDesembarque > onibus.getQtdPassag()) {
                System.out.println("Numero de passageiros para desembarque excede o numero de passageiros a bordo!");
                continue;
            }

            onibus.setQtdPassag(onibus.getQtdPassag() - qtdDesembarque);
            onibus.setCapAtual(onibus.getCapMax() - onibus.getQtdPassag());

            gravador.println("Parada " + parada + ":");
            gravador.println("Passageiros desembarcados: " + qtdDesembarque);
            gravador.println("Passageiros restantes: " + onibus.getQtdPassag());
            gravador.println("========================================");
        }

        gravador.println("Fim da viagem.");
        gravador.close();

        System.out.println("Viagem registrada com sucesso!");
    }

    private static void exibirDados() throws IOException {

        System.out.println("Linhas:");
        for (Linha linha : linhas) {
            System.out.println("Nome: " + linha.getNmLinha() + ", Paradas: " + linha.getQtdParadas());
            for (Viagem viagem : linha.getViagens()) {
                System.out.println("  Viagem: " + viagem.getData() + " " + viagem.getHora() + ", Onibus: " + viagem.getOnibus());
            }
        }

        System.out.println("Onibus:");
        for (Onibus onibus : onibusList) {
            System.out.println("Placa: " + onibus.getCodPlaca() + ", Capacidade Máxima: " + onibus.getCapMax() + ", Passageiros Transportados: " + onibus.getQtdPassag());
        }
    }
}
