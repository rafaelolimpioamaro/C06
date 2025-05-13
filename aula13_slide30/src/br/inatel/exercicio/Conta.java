package br.inatel.exercicio;

import java.util.HashSet;

public class Conta {
    private int numero;
    private float saldo;
    private float limite;
    private HashSet<Cliente> clientes;

    public Conta() {
        clientes = new HashSet<>();
    }

    public void sacar(float quantia){
        if(saldo >= quantia){
            saldo -= quantia;
        }
    }

    public void depositar(float quantia){
        if(quantia <= limite){
            saldo += quantia;
        }
    }

    public void mostrarInfo() {
        System.out.println("\n--- Informações da Conta ---");
        System.out.println("Número da conta: " + numero);
        System.out.println("Saldo: " + saldo);
        System.out.println("Limite: " + limite);

        System.out.println("\n--- Informações dos Clientes ---");
        for(Cliente cliente : clientes) {
            try {
                System.out.println(cliente.info());
            } catch(NullPointerException e) {
                System.out.println("Cliente nulo encontrado.");
            }
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
}

