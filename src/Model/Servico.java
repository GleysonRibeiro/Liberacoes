package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Servico {
    private String codigo;
    private String origem;
    private String destino;
    private LocalDate data;
    private LocalTime horario;
    private LocalTime liberacaoPrevista;
    private LocalTime liberacaoRealizada;
    private String justificativaAtraso;
    private Motorista motorista;
    private Veiculo veiculo;
    private Garagem garagemLiberacao;

    // Construtor
    public Servico(String codigo, String origem, String destino, LocalDate data, LocalTime horario,
                   LocalTime liberacaoPrevista, Motorista motorista, Veiculo veiculo,
                   Garagem garagemLiberacao) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.horario = horario;
        this.liberacaoPrevista = liberacaoPrevista;
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.garagemLiberacao = garagemLiberacao;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public LocalDate getData(){
        return this.data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalTime getLiberacaoPrevista() {
        return liberacaoPrevista;
    }

    public void setLiberacaoPrevista(LocalTime liberacaoPrevista) {
        this.liberacaoPrevista = liberacaoPrevista;
    }

    public LocalTime getLiberacaoRealizada() {
        return liberacaoRealizada;
    }

    public void setLiberacaoRealizada(LocalTime liberacaoRealizada) {
        this.liberacaoRealizada = liberacaoRealizada;
    }

    public String getJustificativaAtraso() {
        return justificativaAtraso;
    }

    public void setJustificativaAtraso(String justificativaAtraso) {
        this.justificativaAtraso = justificativaAtraso;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Garagem getGaragemLiberacao() {
        return garagemLiberacao;
    }

    public void setGaragemLiberacao(Garagem garagemLiberacao) {
        this.garagemLiberacao = garagemLiberacao;
    }

    // Métodos adicionais
    public void registrarJustificativaAtraso(String justificativa) {
        this.justificativaAtraso = justificativa;
    }

    public void liberarVeiculo(LocalTime liberacaoRealizada) {
        this.liberacaoRealizada = liberacaoRealizada;
    }

    public void exibirDetalhes() {
        System.out.println("Serviço: " + codigo);
        System.out.println("Origem: " + origem + ", Destino: " + destino);
        System.out.println("Horário: " + horario);
        System.out.println("Liberação Prevista: " + liberacaoPrevista);
        System.out.println("Liberação Realizada: " + liberacaoRealizada);
        System.out.println("Justificativa de Atraso: " + justificativaAtraso);
        System.out.println("Motorista: " + motorista.getNome() + ", Veículo: " + veiculo.getPlaca());
        System.out.println("Garagem de Liberação: " + garagemLiberacao.getNome());
    }
}

