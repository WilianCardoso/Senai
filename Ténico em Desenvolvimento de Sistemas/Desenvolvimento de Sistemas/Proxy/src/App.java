
public class App {

    public static void main(String[] args) {
        Documento doc1 = new DocumentoProxy("Relatorio_Secreto.pdf", "admin");
        doc1.exibir(); // Acesso permitido

        Documento doc2 = new DocumentoProxy("Relatorio_Secreto.pdf", "usuario");
        doc2.exibir(); // Acesso negado
    }
}
