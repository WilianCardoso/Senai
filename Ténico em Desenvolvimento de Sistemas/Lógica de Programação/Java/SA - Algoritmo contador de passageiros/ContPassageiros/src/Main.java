
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author wilian_g_cardoso
 */
public class Main {

    private static ArrayList<Onibus> Onibus = new ArrayList<Onibus>();

    private static ArrayList<Linha> linhas = new ArrayList<>();
    private static ArrayList<Onibus> onibusList = new ArrayList<>();
    private static ArrayList<Viagem> viagens = new ArrayList<>();
    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Menu();
    }

    public static void Menu() throws IOException {
        boolean sair = false;
        int op = 0;
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
            System.out.print("Entrada:");
            op = ler.nextInt();
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
                    System.out.println("Opcao invalida!");
            }
        } while (!sair);

    }

    public static void cadastroOnibus() {
        System.err.println("Informe a placa do onibus:");
        System.out.print("ENTRADA:");
        String codPlaca = ler.next();
        System.err.println("Informe a capacidade maxima do onibus:");
        System.out.print("ENTRADA:");
        int capMax = ler.nextInt();
        System.out.println("Onibus cadastrado com sucesso!");

        Onibus onibus = new Onibus(codPlaca, capMax, capMax);
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
        String nmLinha = ler.nextLine();
        System.err.println("Informe a linha");
        System.out.print("Entrada:");
        nmLinha = ler.nextLine();
        System.err.println("Informe a qantidade de paradas");
        System.out.print("Entrada:");
        int qtdParadas = ler.nextInt();

        Linha linha = new Linha(qtdParadas, nmLinha);
        linhas.add(linha);
        System.out.println("Sua linha foi cadastrada com Sucesso!");
    }

    public static void decorrerViagem() {

    }

    private static void exibirDados() throws IOException {
        FileWriter arquivo = new FileWriter("registro.txt", true);
        PrintWriter gravador = new PrintWriter(arquivo);
        System.out.println("Linhas:");
        for (Linha linha : linhas) {
            System.out.println("Nome: " + linha.getNmLinha() + ", Paradas: " + linha.getQtdParadas());
            for (Viagem viagem : linha.getViagens()) {
                System.out.println("  Viagem: " + viagem.getData() + " " + viagem.getHora() + ", Ônibus: " + viagem.getOnibus());
            }
        }
        System.out.println("Onibus:");
        for (Onibus onibus : onibusList) {
            System.out.println("Placa: " + onibus.getCodPlaca() + ", Capacidade Maxima: " + onibus.getCapMax() + ", Passageiros Transportados: " + onibus.getQtdPassag());
        }
    }
}
