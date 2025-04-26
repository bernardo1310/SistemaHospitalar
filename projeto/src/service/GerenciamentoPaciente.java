package service;

import dados.Paciente;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoPaciente {
    private List<Paciente> pacientes;

    public GerenciamentoPaciente() {
        this.pacientes = new ArrayList<>();
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente " + paciente.getNome() + " cadastrado com sucesso.");
    }

    public void removerPaciente(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                pacientes.remove(paciente);
                System.out.println("Paciente " + paciente.getNome() + " removido com sucesso.");
                return;
            }
        }
        System.out.println("Paciente com ID " + id + " não encontrado.");
    }

    public Paciente consultarPaciente(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        System.out.println("Paciente com ID " + id + " não encontrado.");
        return null;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            System.out.println("Lista de pacientes cadastrados:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }
}
