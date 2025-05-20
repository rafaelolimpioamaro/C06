package br.inatel.projeto_POO;

import br.inatel.projeto_POO.auxiliares.EnlaceInvalidoException;
import br.inatel.projeto_POO.auxiliares.GestorEnlaces;
import br.inatel.projeto_POO.enlaces.PontoAPonto;
import br.inatel.projeto_POO.enlaces.PontoMultiponto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GestorEnlaces gestorEnlaces = new GestorEnlaces();
        int escolha;
        boolean executando = true;

        System.out.println("=========== Seja Bem-Vindo ===========\n");


        while (executando) {
            System.out.println("Digite 1 - para Enlace Multiponto " + "\nDigite 2 - para Enlace Ponto a Ponto " +
                    "\nDigite 3 - para ver a lista de Enlaces" + "\nDigite 4 - para sair do programa\n " +
                    "\n=======================================" + "\nDigite sua escolha: ");
            try {
                escolha = scan.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Quantos enlaces Multipontos voce deseja cadastrar: ");
                        int QtdPontoMultiponto = scan.nextInt();
                        for (int j = 0; j < QtdPontoMultiponto; j++) {
                            try {
                                System.out.println("\nCadastro do enlace Ponto Multiponto #" + (j + 1));
                                System.out.print("Frequência (MHz): ");
                                double freq = scan.nextDouble();
                                System.out.print("Distância (km): ");
                                double dist = scan.nextDouble();
                                System.out.print("Potência do transmissor (dBm): ");
                                double pot = scan.nextDouble();
                                System.out.print("Sensibilidade do receptor (dBm): ");
                                double sens = scan.nextDouble();
                                PontoMultiponto multiponto = new PontoMultiponto(freq, dist, pot, sens);
                                gestorEnlaces.adicionarEnlace(multiponto);

                            } catch (EnlaceInvalidoException e) {
                                System.err.println("Erro ao cadastrar enlace: " + e.getMessage());
                                j--; // para refazer o cadastro
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Quantos enlaces Ponto a Ponto voce deseja cadastrar: ");
                        int QtdPontaAPonto = scan.nextInt();
                        for (int j = 0; j < QtdPontaAPonto; j++) {
                            try {
                                System.out.println("\nCadastro do enlace Ponto a Ponto #" + (j + 1));
                                System.out.print("Frequência (MHz): ");
                                double freq = scan.nextDouble();
                                System.out.print("Distância (km): ");
                                double dist = scan.nextDouble();
                                System.out.print("Potência do transmissor (dBm): ");
                                double pot = scan.nextDouble();
                                System.out.print("Sensibilidade do receptor (dBm): ");
                                double sens = scan.nextDouble();

                                PontoAPonto ponto = new PontoAPonto(freq, dist, pot, sens);
                                gestorEnlaces.adicionarEnlace(ponto);

                            } catch (EnlaceInvalidoException e) {
                                System.err.println("Erro ao cadastrar enlace: " + e.getMessage());
                                j--; // para refazer o cadastro
                            }

                        }
                        break;

                    case 3:
                        gestorEnlaces.listarEnlaces();
                        break;

                    case 4:
                        executando = false;
                        break;

                    default:
                        System.out.println("Opção escolhida não existente. Tente novamente. \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scan.nextLine();
            }
        }
        System.out.println("\n============= Obrigado pela atençao ===========");
        scan.close();
    }
}