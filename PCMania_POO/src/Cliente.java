public class Cliente {
    String nome;
    long cpf;
    Computador[] computador;

    public Cliente() {
        this.computador = new Computador[3];
    }

    float calculaTotalCompra(){
        float preco=0;

        for (int i = 0; i < computador.length; i++) {
            if (computador[i] != null)
                preco = preco + computador[i].preco;
        }

        return preco;
    }
}
