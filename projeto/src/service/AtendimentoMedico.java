package service;

import dados.Paciente;
import dados.Medico;
import dados.Sala;
import estrutura.Fila;

public class AtendimentoMedico {
    private Fila filaPacientes;

    public AtendimentoMedico(Fila filaPacientes) {
        this.filaPacientes = filaPacientes;
    }

    public void atenderPaciente(Medico medico, Sala sala) {
        if (filaPacientes.estaVazia()) {
            System.out.println("Nenhum paciente na fila para ser atendido.");
            return;
        }

        if (!medico.isDisponivel()) {
            System.out.println("Médico " + medico.getNome() + " não está disponível para atendimento.");
            return;
        }

        if (!sala.adicionarPaciente()) {
            System.out.println("Sala " + sala.getNome() + " está cheia, não é possível atender mais pacientes.");
            return;
        }

        Paciente paciente = filaPacientes.remover();

        medico.setDisponivel(false);

        System.out.println("Médico " + medico.getNome() + " está atendendo o paciente " + paciente.getNome() + ".");

        medico.setDisponivel(true);

        sala.liberarSala();
    }
}
