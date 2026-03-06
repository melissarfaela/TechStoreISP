import service.ClienteService;
import service.ClienteVipService;
import strategy.ICadastro;

public class Main {
    public static void main(String[] args) {

        System.out.println("\u001B[33m  ");
        ICadastro clienteNormal = new ClienteService();
        clienteNormal.cadastrarCliente("Melissa", "melissa@email.com");
        System.out.println(clienteNormal.buscarClientePorEmail("melissa@email.com"));

        System.out.println("\u001B[34m  ");

        ClienteVipService clienteVIP = new ClienteVipService();
        clienteVIP.cadastrarCliente("Gabrielli", "gabrielli@email.com");
        System.out.println(clienteVIP.buscarClientePorEmail("gabrielli@email.com"));

        clienteVIP.enviarNotificacao("gabrielli@email.com", "Parabéns, você ganhou um desconto!");
        clienteVIP.aplicarDescontoVIP("gabrielli@email.com", 15.0);
    }
}