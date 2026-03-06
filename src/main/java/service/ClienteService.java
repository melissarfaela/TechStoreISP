package service;

import strategy.ICadastro;

public class ClienteService implements ICadastro {
    @Override
    public void cadastrarCliente(String nome, String email) {
        System.out.println("VIP: Cadastrando " + nome);
    }
    @Override
    public String buscarClientePorEmail(String email) {
        return "VIP: Encontrado cliente com email " + email;
    }
}
