import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com o seu CPF: ");

        String cpf = ler.nextLine();

        // Valida se tem 11 digitos
        if (cpf.length() != 11 || !cpf.matches("\\d+")) {
            System.out.println("CPF inválido! Deve conter 11 dígitos.");
        }

        int[] cpf_digitos = new int[11];

        // Converter a string CPF para um array de números inteiros
        for (int i = 0; i < 11; i++) {
            cpf_digitos[i] = Character.getNumericValue(cpf.charAt(i));
        }

        // Chama a função de validação
        boolean res = validarCPF(cpf_digitos);

        if (res && cpf.matches("(\\d)\\1{10}")) {
            System.out.println("CPF válido!");
        } else {
            System.out.println("CPF inválido!");
            System.out.println("CPF não pode conter numeros iguais!");

        }
        /*
         * ler.close();
         * 
         * if (cpf.matches("(\\d)\\1{10}")) {
         * System.out.println("CPF não pode conter numeros iguais!");
         * }
         */
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