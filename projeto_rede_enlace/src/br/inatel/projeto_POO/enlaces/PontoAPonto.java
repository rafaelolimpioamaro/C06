package br.inatel.projeto_POO.enlaces;
import br.inatel.projeto_POO.auxiliares.EnlaceInvalidoException;

public class PontoAPonto extends Enlace {
    public PontoAPonto(double frequencia, double distancia, double potencia, double sensibilidade) throws EnlaceInvalidoException {
        super(frequencia, distancia, potencia, sensibilidade);
    }

    @Override
    public double calcularDisponibilidade() {
        return 100 - (distancia * 0.5);
    }

    @Override
    public void verificarCondicoesOperacionais() {
        if (potenciaTransmissor < sensibilidadeReceptor) {
            System.out.println("Atenção: Link Ponto a Ponto fora de operação.");
        } else {
            System.out.println("Link Ponto a Ponto operacional.");
        }
    }
}
