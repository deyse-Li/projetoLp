import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class CidadeConsciente implements ICidadeConsciente {
    private ArrayList<Rua> ruas;

    public CidadeConsciente() {
        ruas = new ArrayList<>();
    }

    @Override
    public void cadastrarRua(String nomeRua) throws RuaJaExisteException {
        Rua nova = new Rua(nomeRua);
        if (ruas.contains(nova)) {
            throw new RuaJaExisteException("A rua \"" + nomeRua + "\" já está cadastrada!");
        }
        ruas.add(nova);
    }

    @Override
    public Rua buscarRua(String nomeRua) {
        for (Rua r : ruas) {
            if (r.getNome().equalsIgnoreCase(nomeRua)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void cadastrarProblema(String nomeRua, String descricaoProblema) {
        Rua r = buscarRua(nomeRua);
        if (r != null) {
            r.adicionarProblema(descricaoProblema);
        } else {
            JOptionPane.showMessageDialog(null, "Rua não encontrada!");
        }
    }

    @Override
    public void listarRuas() {
        if (ruas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma rua cadastrada!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Rua r : ruas) {
            sb.append(r).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    @Override
    public void salvarDados(String arquivo) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Rua r : ruas) {
                bw.write("Rua;" + r.getNome());
                bw.newLine();
                for (Problema p : r.getProblemas()) {
                    bw.write("Problema;" + p.getDescricao());
                    bw.newLine();
                }
            }
        }
    }

    @Override
    public void carregarDados(String arquivo) throws Exception {
        ruas.clear();
        Rua ruaAtual = null;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";", 2);
                if (partes[0].equals("Rua")) {
                    ruaAtual = new Rua(partes[1]);
                    ruas.add(ruaAtual);
                } else if (partes[0].equals("Problema") && ruaAtual != null) {
                    ruaAtual.adicionarProblema(partes[1]);
                }
            }
        }
    }
}
