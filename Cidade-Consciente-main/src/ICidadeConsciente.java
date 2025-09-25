public interface ICidadeConsciente {
    void cadastrarRua(String nomeRua) throws RuaJaExisteException;
    Rua buscarRua(String nomeRua);
    void cadastrarProblema(String nomeRua, String descricaoProblema);
    void listarRuas();
    void salvarDados(String arquivo) throws Exception;
    void carregarDados(String arquivo) throws Exception;
}
