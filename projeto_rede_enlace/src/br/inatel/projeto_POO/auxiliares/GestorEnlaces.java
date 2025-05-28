package br.inatel.projeto_POO.auxiliares;

import br.inatel.projeto_POO.enlaces.Enlace;
import java.io.*;

public class GestorEnlaces {
    private final String arquivo = "C:\\Users\\rapha.000\\IdeaProjects\\projeto_rede_enlace\\src\\br\\inatel\\projeto_POO\\arquivo\\enlaces_cadastradas.txt";

    public void adicionarEnlace(Enlace e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            String tipo = e.getClass().getSimpleName();
            writer.write("Tipo: " + tipo +
                    " | Frequência: " + e.getFrequencia() + " MHz" +
                    " | Distância: " + e.getDistancia() + " km" +
                    " | Potência TX: " + e.getPotenciaTransmissor() + " dBm" +
                    " | Sensibilidade RX: " + e.getSensibilidadeReceptor() + " dBm" +
                    " | Disponibilidade: " + e.calcularDisponibilidade() + "%");
            writer.newLine();
        } catch (IOException ex) {
            System.err.println("Erro ao gravar enlace: " + ex.getMessage());
        }
    }

    public void listarEnlaces() {
        File file = new File(arquivo);
        if (!file.exists()) {
            System.out.println("Nenhum enlace cadastrada.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException ex) {
            System.err.println("Erro ao ler o arquivo: " + ex.getMessage());
        }
    }
}