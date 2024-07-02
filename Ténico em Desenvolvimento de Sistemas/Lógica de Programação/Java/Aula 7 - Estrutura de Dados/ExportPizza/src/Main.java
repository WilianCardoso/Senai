
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    private static ArrayList<Pizza> listap = new ArrayList<Pizza>();
    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Menu();
        ler.close();
    }

    public static void Menu() throws Exception {
        Pizza pizza = new Pizza();
        Scanner ler = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println(" _____________Construa Sua PIZZA_______________");
            System.out.println("|             1 - Montar a Pizza               |");
            System.out.println("|             2 - Listar Pizza                 |");
            System.out.println("|             3 - Alterar Pizza                |");
            System.out.println("|             4 - Destruir a Pizza             |");
            System.out.println("|             5 - Destruir todas as Pizzas     |");
            System.out.println("|             6 - Recuperar Pizza              |");
            System.out.println("|             7 - Sair                         |");
            System.out.println(" ______________________________________________");

            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    cadastar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                    apagar();
                    break;
                case 5:
                    deletar();
                    break;
                case 6:
                    recuperar();
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (op != 7);

    }

    public static void cadastar() {
        System.err.println("Qual o tamanho da Pizza? ");
        String tam = ler.nextLine();

        System.err.println("Sabor 1: ");
        String sabor1 = ler.nextLine();

        System.err.println("Sabor 2: ");
        String sabor2 = ler.nextLine();

        System.err.println("Com borda? (SIM/NAO) ");
        String borda = ler.nextLine().trim().toLowerCase();//remove espaço em branco e converte letra para minuscula.
        boolean comBorda = false;
        if (borda.equals("sim")) {
            comBorda = true;
            System.out.println("Voce escolheu sua pizza com borda.");
        } else if (borda.equals("nao")) {
            comBorda = false;
            System.out.println("Voce escolheu sua pizza sem borda.");
        } else {
            System.out.println("Entrada invalida, digite 'sim' ou 'nao'.");
            return;
        }

        System.err.println("Qual o formato da pizza? ");
        String formato = ler.nextLine();

        System.err.println("Quantas fatias ");
        int fatias = ler.nextInt();
        ler.nextLine(); // Consumir a quebra de linha

        System.err.println("Será premium? (SIM/NAO) ");
        String premium = ler.nextLine().trim().toLowerCase();
        boolean isPremium = false;
        if (premium.equals("sim")) {
            isPremium = true;
            System.out.println("Voce escolheu sua pizza com premium.");
        } else if (premium.equals("nao")) {
            isPremium = false;
            System.out.println("Voce nao quis o premium.");
        } else {
            System.out.println("Entrada invalida, digite 'sim' ou 'nao'.");
            return;
        }

        Pizza pizza = new Pizza(tam, sabor1, sabor2, comBorda, formato, fatias, isPremium);
        listap.add(pizza);
        System.out.println("Sua pizza foi cadastrada com sucesso!");
    }

    public static void listar() throws IOException {
        if (listap.isEmpty()) {
            System.err.println("Nenhuma pizza cadastrada!");
            return;
        }
        FileWriter arquivo = new FileWriter("registro.txt", true);
        PrintWriter gravador = new PrintWriter(arquivo);
        String relatorio = "";
        gravador.printf("---Lista de Pizza---\r\n");
        gravador.print(" |Tamanho|  |Sabor1|  |Sabor2|  |Borda?| |Formato| |Fatias| |Premium?| \n");

        for (int i = 0; i < listap.size(); i++) {
            Pizza pizza = listap.get(i);
            System.out.println(pizza);
            gravador.println(pizza);
            relatorio = "\nFormato: " + pizza.getFormato()
                    + "\nPrimeiro sabor: " + pizza.getSabor1()
                    + "\nSegundo sabor: " + pizza.getSabor2()
                    + "\nTamanho: " + pizza.getTam()
                    + "\nQuantidade de Fatias: " + pizza.getFatias()
                    + "\nTem borda? " + pizza.isBord()
                    + "\nE premium? " + pizza.isPremium()
                    + "\n------------------------------------------";
        }
        gravador.close();
    }

    public static void alterar() {
        if (listap.size() == 0) {
            System.out.println("nenhuma pizza cadastrada");
            return;
        }
        Scanner input = new Scanner(System.in);

        System.out.println(
                "Informe o tamanho da pizza para alterar");
        String pesquisar = input.nextLine();

        for (int i = 0; i < listap.size(); i++) {
            Pizza tam = listap.get(i);
            if (pesquisar.equalsIgnoreCase(tam.getTam())) {
                System.out.println("Informe o novo tamanho");
                String novotam = input.nextLine();

                tam.setTam(novotam);
                break;
            }
            System.out.println("Sabor alterado com sucesso! ");
        }
    }

    public static void apagar() {
        if (listap.size() == 0) {
            System.out.println("Informe o sabor cadastrado");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o sabor da pizza para apagar");
        String pesquisar = input.nextLine();
        for (int i = 0; i < listap.size(); i++) {
            Pizza pizza = listap.get(i);
            if (pesquisar.equalsIgnoreCase(pizza.getSabor1()) || pesquisar.equals(pizza.getSabor2())) {
                listap.remove(i);
                System.out.println("sabor apagado com sucesso! ");
            }
        }
    }

    public static void deletar() {
        if (listap.size() == 0) {
            System.out.println("Nenhuma pizza Cadastrada");
            return;
        }
        listap.clear();
        System.out.println("Todas as pizzas apagadas com sucesso");
    }

    public static void recuperar() {
        String exib = "";
        String aarq = "registro.txt";
        String linha = "";
        File arq = new File(aarq);

        if (arq.exists()) {
            exib = "Recuperado \n";
            try {
                exib += "";
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    exib += linha + "\n";
                }
                leitor.close();
            } catch (Exception erro) {
            }
            System.out.println(exib);
        }
    }

}
