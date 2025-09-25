import java.util.ArrayList;
import java.util.Objects;

public class Rua {
    private String nome;
    private ArrayList<Problema> problemas;

    public Rua(String nome) {
        this.nome = nome;
        this.problemas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarProblema(String descricao) {
        Problema p = new Problema(descricao);
        problemas.add(p);
    }

    public ArrayList<Problema> getProblemas() {
        return problemas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rua: ").append(nome).append("\n");
        if (problemas.isEmpty()) {
            sb.append("  Nenhum problema registrado.\n");
        } else {
            sb.append("  Problemas:\n");
            for (Problema p : problemas) {
                sb.append("   - ").append(p).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rua)) return false;
        Rua rua = (Rua) o;
        return Objects.equals(nome.toLowerCase(), rua.nome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }
}
