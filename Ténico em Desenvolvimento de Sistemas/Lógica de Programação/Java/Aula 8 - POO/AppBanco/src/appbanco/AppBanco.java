package appbanco;

import java.util.Scanner;

/**
 *
 * @author wilian_g_cardoso
 */
public class AppBanco {

    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        Conta conta = new Conta();
        Conta conta2 = new Conta();
        int opcao = 0;

        while (opcao != 7) {
            menu();
            System.out.print("Escolha uma opcao: ");
            opcao = ler.nextInt();
            ler.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    criarConta(conta);
                    break;
                case 2:
                    verStatus(conta);
                    break;
                case 3:
                    depositar(conta);
                    break;
                case 4:
                    sacar(conta);
                    break;
                case 5:
                    conta.extrato();
                    break;
                case 6:
                    transferir(conta, conta2);
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    public static void menu() {
        System.out.println("============ IntBank ==============");
        System.out.println("= 1 - Criar Conta  2 - Ver Status =");
        System.out.println("= 3 - Depositar    4 - Sacar      =");
        System.out.println("= 5 - Ver Extrato  6 - transferir =");
        System.out.println("= 7 - Sair                        =");
        System.out.println("===================================");
    }

    public static void criarConta(Conta conta) {
        System.out.println("Tipo de Conta: ");
        System.out.println("0 - Corrente");
        System.out.println("1 - Salario");
        System.out.println("2 - Poupanca");
        System.out.print("Entre com o tipo de conta: ");
        int tipo = ler.nextInt();
        ler.nextLine();
        conta.setTipo(tipo);

        System.out.print("Entre com o nome do titular: ");
        String titular = ler.nextLine();
        conta.setTitular(titular);

        System.out.print("Entre com o numero da conta: ");
        int numConta = ler.nextInt();
        ler.nextLine();
        conta.setNumConta(numConta);

        System.out.println("Conta criada com sucesso!");
    }

    public static void verStatus(Conta conta) {
        System.out.println("Estado da conta: " + (conta.isEstado() ? "Ativa" : "Inativa"));
        System.out.println("Tipo de conta: " + conta.getTipo());
        System.out.println("Numero da conta: " + conta.getNumConta());
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Limite: " + conta.getLimite());
    }

    public static void depositar(Conta conta) {
        System.out.print("Entre com o valor a depositar: ");
        float valor = ler.nextFloat();
        ler.nextLine();
        conta.depositar(valor);
    }

    public static void sacar(Conta conta) {
        System.out.print("Entre com o valor a sacar: ");
        float valor = ler.nextFloat();
        ler.nextLine();
        conta.sacar(valor);
    }

    public static void transferir(Conta origem, Conta destino) {
        System.out.print("Entre com o valor a transferir: ");
        float valor = ler.nextFloat();
        ler.nextLine();
        origem.transferir(valor, destino);
    }

}
