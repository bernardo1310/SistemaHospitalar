package service;

import dados.Paciente;
import dados.Medico;
import dados.Sala;
import estrutura.Fila;

public class GerenciamentoAtendimento {
    private Fila filaPacientes;

    public GerenciamentoAtendimento(Fila filaPacientes) {
        this.filaPacientes = filaPacientes;
    }

    public void atenderPaciente(Medico medico, Sala sala) {
        if (medico.isDisponivel() && filaPacientes.getTamanho() > 0) {
            Paciente paciente = filaPacientes.remover();
            System.out.println("Paciente " + paciente.getNome() + " está sendo atendido pelo médico " + medico.getNome() + " na sala " + sala.getNome());
            medico.setDisponivel(false);
            paciente.setPrioridade(5);
        } else if (!medico.isDisponivel()) {
            System.out.println("Médico " + medico.getNome() + " não está disponível para atendimento.");
        } else {
            System.out.println("Nenhum paciente na fila para atendimento.");
        }
    }

    public void liberarMedico(Medico medico) {
        if (!medico.isDisponivel()) {
            medico.setDisponivel(true);
            System.out.println("Médico " + medico.getNome() + " agora está disponível.");
        }
    }

    public void gerarRelatorioAtendimentos(Medico medico, int atendimentos) {
        System.out.println("Médico " + medico.getNome() + " atendeu " + atendimentos + " pacientes.");
    }
}
