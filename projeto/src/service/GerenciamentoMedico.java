package service;

import dados.Medico;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoMedico {
    private List<Medico> medicos;

    public GerenciamentoMedico() {
        this.medicos = new ArrayList<>();
    }

    public void cadastrarMedico(Medico medico) {
        medicos.add(medico);
        System.out.println("Médico " + medico.getNome() + " cadastrado com sucesso.");
    }

    public void removerMedico(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                medicos.remove(medico);
                System.out.println("Médico " + medico.getNome() + " removido com sucesso.");
                return;
            }
        }
        System.out.println("Médico com ID " + id + " não encontrado.");
    }

    public Medico consultarMedico(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        System.out.println("Médico com ID " + id + " não encontrado.");
        return null;
    }

    public void alocarMedicoParaSala(Medico medico) {
        if (medico.isDisponivel()) {
            medico.setDisponivel(false);
            System.out.println("Médico " + medico.getNome() + " alocado para a sala de atendimento.");
        } else {
            System.out.println("Médico " + medico.getNome() + " não está disponível.");
        }
    }

    public void liberarMedico(Medico medico) {
        if (!medico.isDisponivel()) {
            medico.setDisponivel(true);
            System.out.println("Médico " + medico.getNome() + " liberado e agora está disponível.");
        } else {
            System.out.println("Médico " + medico.getNome() + " já está disponível.");
        }
    }

    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            System.out.println("Lista de médicos cadastrados:");
            for (Medico medico : medicos) {
                System.out.println(medico);
            }
        }
    }

    public List<Medico> getMedicos() {
        return medicos;
    }
}
