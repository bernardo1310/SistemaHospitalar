package estrutura;

import dados.Paciente;

public class Nodo {
    private Paciente paciente;
    private Nodo prox;

    // Construtor
    public Nodo(Paciente paciente) {
        this.paciente = paciente;
        this.prox = null;
    }

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }
}
