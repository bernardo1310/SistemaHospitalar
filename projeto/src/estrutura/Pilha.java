package estrutura;

import dados.Paciente;

public class Pilha {
    private Nodo topo;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void empilhar(Paciente paciente) {
        Nodo novoItem = new Nodo(paciente);
        if (estaVazia()) {
            topo = novoItem;
        } else {
            novoItem.setProx(topo);
            topo = novoItem;
        }
        tamanho++;
    }

    public Paciente desempilhar() {
        if (estaVazia()) {
            return null;
        }
        Paciente paciente = topo.getPaciente();
        topo = topo.getProx();
        tamanho--;
        return paciente;
    }

    public Paciente topo() {
        if (estaVazia()) {
            return null;
        }
        return topo.getPaciente();
    }
}
