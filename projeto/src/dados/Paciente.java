package dados;

public class Paciente {
    private int id;
    private String nome;
    private String descricao;
    private int prioridade;

    public Paciente(int id, String nome, String descricao, int prioridade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Paciente ID: " + id + " | Nome: " + nome + " | Descrição: " + descricao + " | Prioridade: " + prioridade;
    }
}
