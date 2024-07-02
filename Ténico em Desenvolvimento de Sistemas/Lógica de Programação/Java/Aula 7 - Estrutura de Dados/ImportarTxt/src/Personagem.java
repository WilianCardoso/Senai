/**
 *
 * @author wilian_g_cardoso
 */
public class Personagem {
    private int cod;
    private String nome;
    private int codigoP = 0;
    private String categoria;
    private String filme;
    private String cor;
    
    public Personagem(){
        codigoP++;
        cod = codigoP;
    }
    
    public Personagem(String nome, String categoria, String filme, String cor){
        codigoP++;
        cod = codigoP;
        this.nome = nome;
        this.categoria = categoria;
        this.filme = filme;
        this.cor = cor;
    }
    
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCodigP() {
        return codigoP;
    }
    public void setCodigP(int codigP) {
        this.codigoP = codigP;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getFilme() {
        return filme;
    }
    public void setFilme(String filme) {
        this.filme = filme;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String toString(){
        return "" + nome + ", " + categoria + ", " + filme + ", " + cor;
    } 
    
}
