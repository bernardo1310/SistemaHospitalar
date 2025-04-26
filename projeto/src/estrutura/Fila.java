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

    public void inserir(Paciente paciente) {
        if (temEspaco()) {
            Nodo novoNodo = new Nodo(paciente);
            if (estaVazia()) {
                inicio = novoNodo;
                setFim(novoNodo);
            } else {
                Nodo atual = inicio;
                Nodo anterior = null;

                // Encontre a posição correta pela prioridade
                while (atual != null && atual.getPaciente().getPrioridade() <= paciente.getPrioridade()) {
                    anterior = atual;
                    atual = atual.getProx();
                }

                if (anterior == null) {
                    // Inserir no início da fila
                    novoNodo.setProx(inicio);
                    inicio = novoNodo;
                } else {
                    // Inserir no meio ou no final
                    novoNodo.setProx(atual);
                    anterior.setProx(novoNodo);
                    if (atual == null) {
                        setFim(novoNodo);
                    }
                }
            }
            tamanho++;
            System.out.println("Paciente " + paciente.getNome() + " adicionado à fila com prioridade " + paciente.getPrioridade() + ".");
        } else {
            System.out.println("Fila cheia! Não foi possível adicionar o paciente " + paciente.getNome() + ".");
        }
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
