package estrutura;

import dados.Paciente;

public class Fila {
    private Nodo inicio;
    private Nodo fim;
    private int limite;
    private int tamanho;

    public Fila(int limite) {
        this.inicio = null;
        this.setFim(null);
        this.limite = limite;
        this.tamanho = 0;
    }

    public Nodo getFim() {
        return fim;
    }

    public void setFim(Nodo fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean temEspaco() {
        return tamanho < limite;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean inserir(Paciente paciente) {
        if (temEspaco()) {
            Nodo novoNodo = new Nodo(paciente);
            if (estaVazia()) {
                inicio = novoNodo;
                setFim(novoNodo);
            } else {
                Nodo atual = inicio;
                Nodo anterior = null;

                while (atual != null && atual.getPaciente().getPrioridade() <= paciente.getPrioridade()) {
                    anterior = atual;
                    atual = atual.getProx();
                }

                if (anterior == null) {
                    novoNodo.setProx(inicio);
                    inicio = novoNodo;
                } else {
                    novoNodo.setProx(atual);
                    anterior.setProx(novoNodo);
                    if (atual == null) {
                        setFim(novoNodo);
                    }
                }
            }
            tamanho++;
            return true;
        }
        return false;
    }

    public Paciente remover() {
        if (!estaVazia()) {
            Paciente paciente = inicio.getPaciente();
            inicio = inicio.getProx();
            tamanho--;
            if (estaVazia()) {
                setFim(null);
            }
            return paciente;
        }
        return null;
    }

    public void exibirFila() {
        if (estaVazia()) {
            System.out.println("A fila está vazia.");
            return;
        }
        System.out.println("Pacientes na fila (ordenada por prioridade):");
        Nodo atual = inicio;
        while (atual != null) {
            System.out.println("- " + atual.getPaciente().getNome() + " (Prioridade: " + atual.getPaciente().getPrioridade() + ")");
            atual = atual.getProx();
        }
    }
}
