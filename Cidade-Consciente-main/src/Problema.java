import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Problema {
    private String descricao;

    public Problema(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Problema: " + descricao;
    }
}
