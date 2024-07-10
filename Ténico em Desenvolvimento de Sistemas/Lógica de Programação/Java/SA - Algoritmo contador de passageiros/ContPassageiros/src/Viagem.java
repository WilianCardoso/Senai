
import java.util.ArrayList;

/**
 *
 * @author wilian_g_cardoso
 */
public class Viagem {

    private String nmViagem;
    private String onibus;
    private String data;
    private String hora;


    //construtores
    public Viagem(String data, String hora, String nmViagem, String onibus) {
        this.data = data;
        this.hora = hora;
        this.nmViagem = nmViagem;
        this.onibus = onibus;
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

    
        public String getNmViagem() {
        return nmViagem;
    }

    public void setNmViagem(String nmViagem) {
        this.nmViagem = nmViagem;
    }
}
