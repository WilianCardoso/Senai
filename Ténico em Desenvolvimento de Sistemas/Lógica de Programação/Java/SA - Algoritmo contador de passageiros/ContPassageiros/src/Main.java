import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author wilian_g_cardoso
 */
public class Main {
    private static ArrayList<Onibus> listaOnibus = new ArrayList<>();
    private static ArrayList<Linha> listaLinhas = new ArrayList<>();
    private static ArrayList<Viagem> listaViagens = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar ônibus");
            System.out.println("2. Cadastrar linha");
            System.out.println("3. Cadastrar viagem");
            System.out.println("4. Embarcar passageiros");
            System.out.println("5. Desembarcar passageiros");
            System.out.println("6. Salvar dados em arquivo");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarOnibus();
                    break;
                case 2:
                    cadastrarLinha();
                    break;
                case 3:
                    cadastrarViagem();
                    break;
                case 4:
                    embarcarPassageiros();
                    break;
                case 5:
                    desembarcarPassageiros();
                    break;
                case 6:
                    salvarDadosEmArquivo("dados_viagens.txt");
                    break;
                case 7:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 7);

        scanner.close();
    }

    public static void cadastrarOnibus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código do ônibus: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Informe a placa do ônibus: ");
        String placa = scanner.nextLine();

        System.out.print("Informe a capacidade máxima do ônibus: ");
        int capacidadeMaxima = scanner.nextInt();

        Onibus onibus = new Onibus(codigo, placa, capacidadeMaxima);
        listaOnibus.add(onibus);

        System.out.println("Ônibus cadastrado com sucesso!");

        scanner.close();
    }

    public static void cadastrarLinha() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome da linha: ");
        String nome = scanner.nextLine();

        Linha linha = new Linha(nome);
        listaLinhas.add(linha);

        System.out.println("Linha cadastrada com sucesso!");

        scanner.close();
    }

    public static void cadastrarViagem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Selecione o ônibus para a viagem (informe o código): ");
        int codigoOnibus = scanner.nextInt();
        Onibus onibusSelecionado = null;
        for (Onibus onibus : listaOnibus) {
            if (onibus.getCodigo() == codigoOnibus) {
                onibusSelecionado = onibus;
                break;
            }
        }
        if (onibusSelecionado == null) {
            System.out.println("Ônibus não encontrado.");
            return;
        }

        scanner.nextLine(); // Limpar o buffer

        System.out.print("Informe a data da viagem (AAAA-MM-DD): ");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString);

        System.out.print("Informe a hora da viagem (HH:MM): ");
        String horaString = scanner.nextLine();
        LocalTime hora = LocalTime.parse(horaString);

        System.out.print("Selecione a linha para a viagem (informe o nome da linha): ");
        String nomeLinha = scanner.nextLine();
        Linha linhaSelecionada = null;
        for (Linha linha : listaLinhas) {
            if (linha.getNome().equals(nomeLinha)) {
                linhaSelecionada = linha;
                break;
            }
        }
        if (linhaSelecionada == null) {
            System.out.println("Linha não encontrada.");
            return;
        }

        Viagem viagem = new Viagem(onibusSelecionado, data, hora, linhaSelecionada);
        listaViagens.add(viagem);

        System.out.println("Viagem cadastrada com sucesso!");

        scanner.close();
    }

    public static void embarcarPassageiros() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código do ônibus: ");
        int codigoOnibus = scanner.nextInt();
        Onibus onibusSelecionado = null;
        for (Onibus onibus : listaOnibus) {
            if (onibus.getCodigo() == codigoOnibus) {
                onibusSelecionado = onibus;
                break;
            }
        }
        if (onibusSelecionado == null) {
            System.out.println("Ônibus não encontrado.");
            return;
        }

        System.out.print("Informe a quantidade de passageiros a embarcar: ");
        int quantidade = scanner.nextInt();

        onibusSelecionado.embarcarPassageiros(quantidade);

        System.out.println("Embarque realizado com sucesso!");

        scanner.close();
    }

    public static void desembarcarPassageiros() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código do ônibus: ");
        int codigoOnibus = scanner.nextInt();
        Onibus onibusSelecionado = null;
        for (Onibus onibus : listaOnibus) {
            if (onibus.getCodigo() == codigoOnibus) {
                onibusSelecionado = onibus;
                break;
            }
        }
        if (onibusSelecionado == null) {
            System.out.println("Ônibus não encontrado.");
            return;
        }

        System.out.print("Informe a quantidade de passageiros a desembarcar: ");
        int quantidade = scanner.nextInt();

        onibusSelecionado.desembarcarPassageiros(quantidade);

        System.out.println("Desembarque realizado com sucesso!");

        scanner.close();
    }

    public static void salvarDadosEmArquivo(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (Viagem viagem : listaViagens) {
                writer.write("Data: " + viagem.getData() + ", Hora: " + viagem.getHora() + "\n");
                writer.write("Ônibus: " + viagem.getOnibus().getPlaca() + ", Linha: " + viagem.getLinha().getNome() + "\n");
                writer.write("Passageiros presentes: " + viagem.getOnibus().getQuantidadePassageiros() + "\n");
                writer.write("\n");
            }
            System.out.println("Dados salvos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados no arquivo: " + e.getMessage());
        }
    }
}