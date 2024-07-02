
/**
 *
 * @author wilian_g_cardoso
 */
public class Viagem {

    private String onibus;
    private String data;
    private String hora;
    private String linha;

    //construtores
    public Viagem(String data, String hora, String linha, String onibus) {
        this.data = data;
        this.hora = hora;
        this.linha =linha;
        this.onibus = onibus;
    }
    public Viagem(){
        
    }

    //Getters and Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOnibus() {
        return onibus;
    }

    public void setOnibus(String onibus) {
        this.onibus = onibus;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }
}
