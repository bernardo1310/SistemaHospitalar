package dados;

public class Medico {
    private int id;
    private String nome;
    private String especialidade;
    private boolean disponivel;

    // Construtor ajustado
    public Medico(int id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponivel = true; // Inicialmente o médico está disponível
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Médico ID: " + id + " | Nome: " + nome + " | Especialidade: " + especialidade + " | Disponível: " + disponivel;
    }
}
