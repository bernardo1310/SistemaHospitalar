package service;

import dados.Paciente;
import estrutura.Fila;

public class Triagem {
    private Fila filaPacientes;

    public Triagem(Fila filaPacientes) {
        this.filaPacientes = filaPacientes;
    }

    public void realizarTriagem(Paciente paciente) {
        filaPacientes.inserir(paciente);
        System.out.println("Paciente " + paciente.getNome() + " adicionado na fila com prioridade " + paciente.getPrioridade() + ".");
    }
}
