package Model;

public class Veiculo {

    private String placa;
    private String prefixo;
    private int capacidade;
    private String tipo;

    // Construtor
    public Veiculo(String placa, String prefixo, int capacidade, String tipo) {
        this.placa = placa;
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    // Métodos Getters e Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método para exibir informações do veículo
    public void exibirInformacoes() {
        System.out.println("Veículo:");
        System.out.println("Placa: " + placa);
        System.out.println("Prefixo: " + prefixo);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Tipo: " + tipo);
    }
}

