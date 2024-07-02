/**
 *
 * @author wilian_g_cardoso
 */
public class Linha {
    private String nome;
    private int quantidadeParadas;

    public Linha(String nome) {
        this.nome = nome;
        this.quantidadeParadas = 0; // Inicialmente sem paradas
    }

    // Getters e Setters para acesso aos atributos
    public String getNome() {
        return nome;
    }

    public int getQuantidadeParadas() {
        return quantidadeParadas;
    }

    public void setQuantidadeParadas(int quantidadeParadas) {
        this.quantidadeParadas = quantidadeParadas;
    }
}