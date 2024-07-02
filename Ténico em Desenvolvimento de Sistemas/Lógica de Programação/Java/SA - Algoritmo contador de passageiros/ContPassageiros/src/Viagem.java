import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author wilian_g_cardoso
 */
public class Viagem {
    private Onibus onibus;
    private LocalDate data;
    private LocalTime hora;
    private Linha linha;

    public Viagem(Onibus onibus, LocalDate data, LocalTime hora, Linha linha) {
        this.onibus = onibus;
        this.data = data;
        this.hora = hora;
        this.linha = linha;
    }

    // Getters para acesso aos atributos
    public Onibus getOnibus() {
        return onibus;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Linha getLinha() {
        return linha;
    }
}