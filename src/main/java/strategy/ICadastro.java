package strategy;

public interface ICadastro {
    void cadastrarCliente(String nome, String email);
    String buscarClientePorEmail(String email);


}
