/**
 *
 * @author wilian_g_cardoso
 */
public class Onibus {
    private int codigo;
    private String placa;
    private int capacidadeMaxima = 0;
    private int capacidadeAtual;
    private int quantidadePassageiros;

    public Onibus(int codigo, String placa, int capacidadeMaxima) {
        this.codigo = codigo;
        this.placa = placa;
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeMaxima; // Começa com a capacidade máxima
        this.quantidadePassageiros = 0; // Inicialmente sem passageiros
    }

    // Getters e Setters para acesso aos atributos
    public int getCodigo() {
        return codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void embarcarPassageiros(int quantidade) {
        if (quantidade <= capacidadeAtual) {
            quantidadePassageiros += quantidade;
            capacidadeAtual -= quantidade;
        } else {
            System.out.println("Capacidade excedida. Nao foi possível embarcar todos os passageiros.");
        }
    }

    public void desembarcarPassageiros(int quantidade) {
        if (quantidade <= quantidadePassageiros) {
            quantidadePassageiros -= quantidade;
            capacidadeAtual += quantidade;
        } else {
            System.out.println("Quantidade de passageiros a desembarcar maior que a quantidade presente no onibus.");
        }
    }
}