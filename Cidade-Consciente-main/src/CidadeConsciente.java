import javax.swing.*;
import java.util.ArrayList;

import javax.swing.*;
import java.util.ArrayList;

public class CidadeConsciente {
    private ArrayList<Rua> ruas;

    public CidadeConsciente() {
        ruas = new ArrayList<>();
    }

    public void cadastrarRua(String nomeRua){
        Rua r = new Rua(nomeRua);
        ruas.add(r);
    }

    public Rua buscarRua(String nomeRua) {
        for (Rua r : ruas) {
            if (r.getNome().equalsIgnoreCase(nomeRua)) {
                return r;
            }
        }
        return null;
    }

    public void cadastrarProblema(String nomeRua, String descricaoProblema) {
        Rua r = buscarRua(nomeRua);
        if (r != null) {
            r.adicionarProblema(descricaoProblema);
        } else {
            JOptionPane.showMessageDialog(null, "Rua não encontrada!");
        }
    }

    public ArrayList<Rua> getRuas() {
        return ruas;
    }
}

