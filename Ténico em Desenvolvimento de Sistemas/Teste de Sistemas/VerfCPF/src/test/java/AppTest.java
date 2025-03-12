
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author wilian_g_cardoso
 */
public class AppTest {
   App verificador = new App();
    @Test
    void testValidaQtdDigitos() {
        assertTrue(verificador.validaQtdDigitos("12345678901"));  // CPF correto
        assertFalse(verificador.validaQtdDigitos("12345678"));    // Menos de 11 dígitos
        assertFalse(verificador.validaQtdDigitos("123456789012")); // Mais de 11 dígitos
        assertFalse(verificador.validaQtdDigitos("abc12345678")); // Letras no meio
    }

    @Test
    void testVerfLetras() {
        assertTrue(verificador.verfLetras("abc12345678"));  // Tem letras
        assertFalse(verificador.verfLetras("12345678901")); // Apenas números
    }

    @Test
    void testVerfIgual() {
        assertTrue(verificador.verfIgual("11111111111"));  // Todos os números iguais
        assertFalse(verificador.verfIgual("12345678901")); // CPF normal
    }

    @Test
    void testValidarCPF() {
        int[] cpfValido = {1, 1, 1, 4, 4, 4, 7, 7, 7, 0, 5};  // CPF real válido: 111.444.777-05
        int[] cpfInvalido = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1}; // CPF inválido

        assertTrue(verificador.validarCPF(cpfValido));
        assertFalse(verificador.validarCPF(cpfInvalido));
    }
}
