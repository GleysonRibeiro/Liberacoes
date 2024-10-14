package Model;

public class Celular {
    // Atributos da classe
    private String codigo;
    private String numero;
    private String marca;
    private String modelo;
    private String situacao;
    private Motorista motorista; // Associação com a classe Motorista

    // Construtor da classe
    public Celular(String codigo, String numero, String marca, String modelo, String situacao, Motorista motorista) {
        this.codigo = codigo;
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
        this.situacao = situacao;
        this.motorista = motorista;
    }

    // Métodos getters e setters para acessar e modificar os atributos
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    // Método para exibir as informações do celular
    public void exibirDetalhes() {
        System.out.println("Código: " + codigo);
        System.out.println("Número: " + numero);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Situação: " + situacao);
        if (motorista != null) {
            System.out.println("Motorista Responsável: " + motorista.getNome());
        } else {
            System.out.println("Sem motorista associado.");
        }
    }
}

