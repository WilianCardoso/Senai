
public class DocumentoProxy implements Documento {

    private DocumentoReal documentoReal;
    private String nome;
    private String usuario;

    public DocumentoProxy(String nome, String usuario) {
        this.nome = nome;
        this.usuario = usuario;
    }

    @Override
    public void exibir() {
        if ("admin".equals(usuario)) {
            if (documentoReal == null) {
                documentoReal = new DocumentoReal(nome);
            }
            documentoReal.exibir();
        } else {
            System.out.println("Acesso negado para o usuário: " + usuario);
        }
    }
}
