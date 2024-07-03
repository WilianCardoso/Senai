
/**
 *
 * @author wilian_g_cardoso
 */
public class Onibus {

    private String codPlaca;
    private int capMax = 40;
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

    //Metodos
    public void embarqueNoOnibus() {
        if (this.qtdPassag > this.capMax) {
            System.out.println("O onibus está cheio");
        } else if (this.qtdPassag < this.capMax) {
            this.capAtual += this.qtdPassag;
            System.out.println("Tem " + this.capAtual + "no onibus.");
        }
    }

    public void desembarqueDoOnibus() {
        if (this.qtdPassag > this.capAtual) {
            System.out.println("Numero de passageiros invalidos, nao ha passageiros a bordo suficiente para o desembarque.");
        } else if (this.qtdPassag < this.capAtual) {
            this.capAtual -= this.qtdPassag;
            System.out.println("Ha " + this.capAtual + " no onibus.");
        }
    }

    public void Status() {
        System.out.println("Onibus " + this.codPlaca + ":");
        System.out.println("  Capacidade máxima: " + this.capMax);
        System.out.println("  Capacidade atual: " + this.capAtual);
        System.out.println("  Passageiros a bordo: " + this.capAtual);
    }
}
