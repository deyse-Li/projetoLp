import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CidadeConsciente cidade = new CidadeConsciente();
        String arquivo = "dados.txt";

        int opcao = -1;
        do {
            String menu =
                    "--- Cidade Consciente ---\n" +
                            "1. Cadastrar rua\n" +
                            "2. Cadastrar problema em rua\n" +
                            "3. Buscar rua e ver problemas\n" +
                            "4. Listar todas as ruas\n" +
                            "5. Carregar dados de arquivo\n" +
                            "6. Salvar dados em arquivo\n" +
                            "0. Sair\n";

            String escolha = JOptionPane.showInputDialog(menu);
            if (escolha == null) break;
            try {
                opcao = Integer.parseInt(escolha);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    String nomeRua = JOptionPane.showInputDialog("Nome da rua:");
                    if (nomeRua != null && !nomeRua.isBlank()) {
                        try {
                            cidade.cadastrarRua(nomeRua);
                            JOptionPane.showMessageDialog(null, "Rua cadastrada!");
                        } catch (RuaJaExisteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    break;

                case 2:
                    String ruaProblema = JOptionPane.showInputDialog("Nome da rua:");
                    if (ruaProblema != null) {
                        String desc = JOptionPane.showInputDialog("Descrição do problema:");
                        if (desc != null && !desc.isBlank()) {
                            cidade.cadastrarProblema(ruaProblema, desc);
                            JOptionPane.showMessageDialog(null, "Problema cadastrado!");
                        }
                    }
                    break;

                case 3:
                    String buscarRua = JOptionPane.showInputDialog("Nome da rua:");
                    if (buscarRua != null) {
                        Rua r = cidade.buscarRua(buscarRua);
                        if (r != null) {
                            JOptionPane.showMessageDialog(null, r.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Rua não encontrada!");
                        }
                    }
                    break;

                case 4:
                    cidade.listarRuas();
                    break;

                case 5:
                    try {
                        cidade.carregarDados(arquivo);
                        JOptionPane.showMessageDialog(null, "Dados carregados de " + arquivo);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao carregar: " + e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        cidade.salvarDados(arquivo);
                        JOptionPane.showMessageDialog(null, "Dados salvos em " + arquivo);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
                    }
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
}
