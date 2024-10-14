package Model;

public class Motorista {

    private String nome;
    private String matricula;

    // Construtor
    public Motorista(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Método para exibir informações do motorista
    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}

