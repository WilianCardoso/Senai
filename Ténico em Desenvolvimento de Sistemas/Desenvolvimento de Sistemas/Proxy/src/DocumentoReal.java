
public class DocumentoReal implements Documento {

    private String nome;

    public DocumentoReal(String nome) {
        this.nome = nome;
        carregarDoDisco();
    }

    private void carregarDoDisco() {
        System.out.println("Carregando documento: " + nome);
    }

    @Override
    public void exibir() {
        System.out.println("Exibindo documento: " + nome);
    }
}
