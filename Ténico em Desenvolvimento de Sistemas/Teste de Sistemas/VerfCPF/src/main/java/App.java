
import java.util.Scanner;

/**
 *
 * @author wilian_g_cardoso
 */
public class App {

    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
         String cpf = "";
        System.out.println("Entre com o seu CPF: ");
        cpf = ler.nextLine();

        if (verfLetras(cpf)) {
            System.out.println( " contem Letras");
            return;
        }

        if (!validaQtdDigitos(cpf)) {
            System.out.println("Número de caracteres é inválido");
            ler.close();
            return;
        }

        if (verfIgual(cpf)) {
            System.out.println(" CPF não pode conter numeros iguais!");
            return;
        }


        int[] cpf_digitos = new int[11];

        // Chama a função de validação
        boolean res = validarCPF(cpf_digitos);

        if (res) {
            System.out.println("CPF válido!");
        } else {
            System.out.println("CPF inválido!");

        }
        // Converter a string CPF para um array de números inteiros
        for (int i = 0; i < 11; i++) {
            cpf_digitos[i] = Character.getNumericValue(cpf.charAt(i));
        }

        ler.close();

    }

    public static boolean verfIgual(String cpf) {
        return cpf.matches("(\\d)\\1{10}");
    }

    public static boolean validaQtdDigitos(String cpfVerificar) {
        // Verifica se o CPF contém apenas números
        return cpfVerificar.matches("\\d{11}"); // Caso true, os digitos estão válido

    }

    public static boolean verfLetras(String cpf) {
        return cpf.matches(".*[A-Za-z].*");
    }

    public static boolean validarCPF(int num[]) {
        int soma = 0, resto, dv1, dv2;

        // Cálculo do primeiro dígito verificador
        for (int i = 0, j = 10; i < 9; i++, j--) {
            soma += num[i] * j;
        }

        resto = soma % 11;
        dv1 = (resto < 2) ? 0 : (11 - resto);

        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0, j = 11; i < 10; i++, j--) {
            soma += num[i] * j;
        }

        resto = soma % 11;
        dv2 = (resto < 2) ? 0 : (11 - resto);

        // Comparação dos dígitos calculados com os informados
        return (num[9] == dv1) && (num[10] == dv2);
    }
}
