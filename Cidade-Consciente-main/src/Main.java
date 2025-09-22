import javax.swing.*;
import java.util.ArrayList;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CidadeConsciente cidade = new CidadeConsciente();
        int opcao;

        do {
            String menu = """
                --- Cidade Consciente ---
                1. Cadastrar rua
                2. Cadastrar problema em rua
                3. Buscar rua e ver problemas
                4. Listar todas as ruas
                0. Sair
                """;

            String escolha = JOptionPane.showInputDialog(menu);
            if (escolha == null) break; // se cancelar, sai
            try {
                opcao = Integer.parseInt(escolha);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> {
                    String nomeRua = JOptionPane.showInputDialog("Nome da rua:");
                    if (nomeRua != null && !nomeRua.isBlank()) {
                        cidade.cadastrarRua(nomeRua);
                        JOptionPane.showMessageDialog(null, "Rua cadastrada!");
                    }
                }
                case 2 -> {
                    String ruaProblema = JOptionPane.showInputDialog("Nome da rua:");
                    if (ruaProblema != null) {
                        String desc = JOptionPane.showInputDialog("Descrição do problema:");
                        if (desc != null && !desc.isBlank()) {
                            cidade.cadastrarProblema(ruaProblema, desc);
                            JOptionPane.showMessageDialog(null, "Problema cadastrado!");
                        }
                    }
                }
                case 3 -> {
                    String buscarRua = JOptionPane.showInputDialog("Nome da rua:");
                    if (buscarRua != null) {
                        Rua r = cidade.buscarRua(buscarRua);
                        if (r != null) {
                            JOptionPane.showMessageDialog(null, r.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Rua não encontrada!");
                        }
                    }
                }
                case 4 -> {
                    StringBuilder lista = new StringBuilder();
                    for (Rua r : cidade.getRuas()) {
                        lista.append(r).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, lista.length() == 0 ? "Nenhuma rua cadastrada!" : lista.toString());
                }
                case 0 -> JOptionPane.showMessageDialog(null, "Saindo...");
                default -> {}
            }
        } while (true);
    }
}
