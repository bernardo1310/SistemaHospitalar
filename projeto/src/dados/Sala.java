package dados;

public class Sala {
    private int id;
    private String nome;
    private int capacidade;
    private int pacientesAtendidos;
    private boolean disponivel;

    // Construtor ajustado
    public Sala(int id, String nome, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.pacientesAtendidos = 0; // Inicializa com 0 pacientes atendidos
        this.disponivel = true;      // A sala começa como disponível
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(int pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Método para adicionar paciente à sala
    public boolean adicionarPaciente() {
        if (pacientesAtendidos < capacidade) {
            pacientesAtendidos++;
            if (pacientesAtendidos == capacidade) {
                disponivel = false; // Se a capacidade for atingida, a sala não está mais disponível
            }
            return true;
        }
        return false; // Não adiciona paciente se a capacidade estiver cheia
    }

    // Método para liberar sala após atendimento
    public void liberarSala() {
        if (pacientesAtendidos > 0) {
            pacientesAtendidos--;
        }
        if (pacientesAtendidos == 0) {
            disponivel = true; // Se não houver mais pacientes, a sala volta a ser disponível
        }
    }

    @Override
    public String toString() {
        return "Sala ID: " + id + " | Nome: " + nome + " | Capacidade: " + capacidade + 
               " | Pacientes Atendidos: " + pacientesAtendidos + " | Disponível: " + disponivel;
    }
}
