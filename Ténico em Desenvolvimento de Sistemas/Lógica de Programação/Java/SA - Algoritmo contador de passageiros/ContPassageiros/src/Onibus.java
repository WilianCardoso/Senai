 
/**
 *
 * @author wilian_g_cardoso
 */
public class Onibus {

    private String codPlaca;
    private int capMax = 0;
    private int capAtual;
    private int qtdPassag;

    //Construtores
    public Onibus(String codPlaca, int capAtual, int qtdPassag) {
        this.codPlaca = codPlaca;
        this.capAtual = capAtual;
        this.qtdPassag = 0;
    }

    public Onibus() {

    }

    //Getters and Setters
    public String getCodPlaca() {
        return codPlaca;
    }

    public void setCodPlaca(String codPlaca) {
        this.codPlaca = codPlaca;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }

    public int getCapAtual() {
        return capAtual;
    }

    public void setCapAtual(int capAtual) {
        this.capAtual = capAtual;
    }

    public int getQtdPassag() {
        return qtdPassag;
    }

    public void setQtdPassag(int qtdPassag) {
        this.qtdPassag = qtdPassag;
    }
}
