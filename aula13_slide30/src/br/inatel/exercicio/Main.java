package br.inatel.exercicio;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = null;

        Conta conta1 = new Conta();

        cliente1.setNome("Begalinha");
        cliente1.setCpf(1778503560);

        cliente2.setNome("Ralf");
        cliente2.setCpf(1162674460);

        // Adicionando os clientes na conta (2 clientes e 1 nulo)
        conta1.adicionarCliente(cliente1);
        conta1.adicionarCliente(cliente2);
        conta1.adicionarCliente(cliente3);

        // Configurando conta
        conta1.setNumero(47584260);
        conta1.setLimite(200000f);
        conta1.depositar(60000f);
        conta1.sacar(2500f);

        // Exibir informações da conta e clientes
        conta1.mostrarInfo();

        System.out.println("\nFim.");
    }
}

