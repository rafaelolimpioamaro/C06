package br.inatel.projeto_POO.auxiliares;
import br.inatel.projeto_POO.enlaces.Enlace;
import java.util.ArrayList;

public class GestorEnlaces {
    private ArrayList<Enlace> enlaces = new ArrayList<>();

    public void adicionarEnlace(Enlace e) {
        enlaces.add(e);
    }

    public void listarEnlaces() {
        for (Enlace e : enlaces) {
            e.exibirInformacoes();
            System.out.println("Disponibilidade: " + e.calcularDisponibilidade() + "%");
            e.verificarCondicoesOperacionais();
            System.out.println("\n ========  Fim da Lista de Enlaces ======== \n");
        }
    }
}
