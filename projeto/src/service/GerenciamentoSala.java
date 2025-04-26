package service;

import dados.Sala;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoSala {
    private List<Sala> salas;

    public GerenciamentoSala() {
        this.salas = new ArrayList<>();
    }

    public void cadastrarSala(Sala sala) {
        salas.add(sala);
        System.out.println("Sala " + sala.getNome() + " cadastrada com sucesso.");
    }

    public void removerSala(int id) {
        Sala sala = consultarSala(id);
        if (sala != null) {
            salas.remove(sala);
            System.out.println("Sala " + sala.getNome() + " removida com sucesso.");
        } else {
            System.out.println("Sala com ID " + id + " não encontrada.");
        }
    }

    public Sala consultarSala(int id) {
        for (Sala sala : salas) {
            if (sala.getId() == id) {
                return sala;
            }
        }
        System.out.println("Sala com ID " + id + " não encontrada.");
        return null;
    }

    public boolean alocarPacienteNaSala(Sala sala) {
        if (sala.isDisponivel()) {
            sala.adicionarPaciente();
            System.out.println("Paciente alocado na " + sala.getNome() + ".");
            return true;
        } else {
            System.out.println("Sala " + sala.getNome() + " não disponível.");
            return false;
        }
    }

    public void liberarSala(Sala sala) {
        sala.liberarSala();
        System.out.println("Sala " + sala.getNome() + " liberada.");
    }

    public void listarSalas() {
        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada.");
        } else {
            System.out.println("Lista de salas cadastradas:");
            for (Sala sala : salas) {
                System.out.println(sala);
            }
        }
    }
}
