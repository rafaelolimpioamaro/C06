import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente1 = new Cliente();

        System.out.println("Digite o nome do cliente: ");
        cliente1.nome = sc.nextLine();

        System.out.println("Digite o CPF: ");
        cliente1.cpf = sc.nextLong();

        Computador[] computador = new Computador[3];

        for (int i = 0; i < computador.length; i++) {
            computador[i] = new Computador();
        }

        MemoriaUSB memoria1 = new MemoriaUSB("Pen-drive", 16);
        MemoriaUSB memoria2 = new MemoriaUSB("Pen-drive", 32);
        MemoriaUSB memoria3 = new MemoriaUSB("HD Externo", 1000);

        computador[0].marca = "Apple";
        computador[1].marca = "Samsung";
        computador[2].marca = "Dell";

        computador[0].preco = 9803f;
        computador[1].preco = 9803f+1234f;
        computador[2].preco = 9803f+5678f;

        //Computador Apple
        computador[0].hardware[0].nome = "Pentium Core i3";
        computador[0].hardware[1].nome = "Memoria Ram";
        computador[0].hardware[2].nome = "HD";

        computador[0].hardware[0].capacidade = 2200f;
        computador[0].hardware[1].capacidade = 8f;
        computador[0].hardware[2].capacidade = 500f;

        computador[0].sistema.nome = "Linux Ubuntu";
        computador[0].sistema.tipo = 32;

        //Computador Samsung
        computador[1].hardware[0].nome = "Pentium Core i5";
        computador[1].hardware[1].nome = "Memoria Ram";
        computador[1].hardware[2].nome = "HD";

        computador[1].hardware[0].capacidade = 3370;
        computador[1].hardware[1].capacidade = 16;
        computador[1].hardware[2].capacidade = 1000;

        computador[1].sistema.nome = "Windows 8";
        computador[1].sistema.tipo = 64;

        //Computador Dell
        computador[2].hardware[0].nome = "Pentium Core i7";
        computador[2].hardware[1].nome = "Memoria Ram";
        computador[2].hardware[2].nome = "HD";

        computador[2].hardware[0].capacidade = 4500;
        computador[2].hardware[1].capacidade = 32;
        computador[2].hardware[2].capacidade = 64;

        computador[2].sistema.nome = "Windows 10";
        computador[2].sistema.tipo = 64;


        //operacao da compra
        Computador[] computadorEscolhido = new Computador[10];
        boolean escolhido = true;
        int continuarCompra;
        int contador = 0;

        while (escolhido) {
            System.out.println("Escolha sua Promoção: ");
            System.out.println("Digite 1 para a promocao 1");
            System.out.println("Digite 2 para a promocao 2");
            System.out.println("Digite 3 para a promocao 3");
            System.out.println("Digite 0 para finalizar ou  sair");
            System.out.println(" ");
            int promo = sc.nextInt();
            int addMem;

            switch (promo) {
                case 1:
                    System.out.println("Informacao sobre o computador 1: ");
                    computador[0].mostraPCCconfigs();
                    System.out.println(" ");
                    System.out.println("Gostaria de comprar? Caso sim digite 1 ou 0 sair");
                    System.out.println(" ");
                    continuarCompra = sc.nextInt();
                    if (continuarCompra == 0){
                        break;
                    }
                    computadorEscolhido[contador] = computador[0];
                    System.out.println("Gostaria de adicionar uma memória de 16Gb?");
                    System.out.println("1- Sim");
                    System.out.println("0- Nao");
                    addMem = sc.nextInt();
                    if (addMem == 0){
                        break;
                    }
                    computador[0].addMemoriaUSB(memoria1);
                    contador++;
                    break;

                case 2:
                    System.out.println("Informacao sobre o computador 2: ");
                    computador[1].mostraPCCconfigs();
                    System.out.println(" ");
                    System.out.println("Gostaria de comprar? Caso sim digite 1 ou 0 sair da promocao");
                    System.out.println(" ");
                    continuarCompra = sc.nextInt();
                    if (continuarCompra == 0){
                        break;
                    }
                    computadorEscolhido[contador] = computador[1];System.out.println("Gostaria de adicionar uma memória de 32Gb?");
                    System.out.println("1- Sim");
                    System.out.println("0- Nao");
                    addMem = sc.nextInt();
                    if (addMem == 0){
                        break;
                    }
                    computador[1].addMemoriaUSB(memoria1);
                    contador++;
                    break;

                case 3:
                    System.out.println("Informacao sobre o computador 3: ");
                    System.out.println(" ");
                    computador[2].mostraPCCconfigs();
                    System.out.println("Gostaria de comprar? Caso sim digite 1 ou 0 sair");
                    System.out.println(" ");
                    continuarCompra = sc.nextInt();
                    if (continuarCompra == 0){
                        break;
                    }
                    computadorEscolhido[contador] = computador[2];

                    System.out.println("Gostaria de adicionar uma memória de 1Tb?");
                    System.out.println("1- Sim");
                    System.out.println("0- Nao");
                    addMem = sc.nextInt();
                    if (addMem == 0){
                        break;
                    }
                    computador[2].addMemoriaUSB(memoria1);
                    contador++;
                    break;

                case 0:
                    System.out.println("Saindo da compra com os seguintes produtos: ");
                    System.out.println(" ");
                    for (int i = 0; i < computadorEscolhido.length; i++) {
                        if (computadorEscolhido[i] != null) {
                            computadorEscolhido[i].mostraPCCconfigs();
                        }
                    }

                    cliente1.computador = computadorEscolhido;

                    System.out.println(" ");
                    System.out.println("Valor total da compra: " + cliente1.calculaTotalCompra());
                    escolhido = false;
                    break;

                default:
                    System.out.println("Erro!");
                    break;
            }
        }
        sc.close();
    }
}
