
import java.util.ArrayList;


/**
 *
 * @author wilian_g_cardoso
 */
public class Linha {

    private int qtdParadas = 0;
    private String nmLinha;
    private ArrayList<Viagem> viagens;

    //construtor
    public Linha(int qtdParadas, String nmLinha) {
        this.qtdParadas = qtdParadas;
        this.nmLinha = nmLinha;
         this.viagens = new ArrayList<>(); 
    }

    public int getQtdParadas() {
        return qtdParadas;
    }

    public void setQtdParadas(int qtdParadas) {
        this.qtdParadas = qtdParadas;
    }

    public String getNmLinha() {
        return nmLinha;
    }

    public void setNmLinha(String nmLinha) {
        this.nmLinha = nmLinha;
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<Viagem> viagens) {
        this.viagens = viagens;
    }
    
    
}
