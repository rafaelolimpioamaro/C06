package br.inatel.projeto_POO.enlaces;

import br.inatel.projeto_POO.auxiliares.EnlaceInvalidoException;
import br.inatel.projeto_POO.auxiliares.Monitoravel;

abstract public class Enlace implements Monitoravel {
    protected double frequencia;
    protected double distancia;
    protected double potenciaTransmissor;
    protected double sensibilidadeReceptor;

    public Enlace(double frequencia, double distancia, double potencia, double sensibilidade) throws EnlaceInvalidoException {
        if (distancia <= 0 || frequencia <= 0) {
            throw new EnlaceInvalidoException("Frequência e distância devem ser maiores que zero.");
        }
        this.frequencia = frequencia;
        this.distancia = distancia;
        this.potenciaTransmissor = potencia;
        this.sensibilidadeReceptor = sensibilidade;
    }

    public abstract double calcularDisponibilidade();

    public void exibirInformacoes() {
        System.out.println("======== Lista de Enlaces ========");
        System.out.println("\nFrequência: " + frequencia + " MHz | Distância: " + distancia + " km");
    }
}
