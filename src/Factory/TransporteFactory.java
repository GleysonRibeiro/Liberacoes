package Factory;

import Model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransporteFactory {

    // Método para criar um Motorista
    public static Motorista criarMotorista(String nome, String matricula) {

        return new Motorista(nome, matricula);
    }

    // Método para criar um Veiculo
    public static Veiculo criarVeiculo(String placa, String prefixo, int capacidade, String tipo) {
        return new Veiculo(placa, prefixo, capacidade, tipo);
    }

    // Método para criar um Celular
    public static Celular criarCelular(String codigo, String numero, String marca, String modelo, String situacao, Motorista motorista) {
        return new Celular(codigo, numero, marca, modelo, situacao, motorista);
    }

    // Método para criar uma Viagem
    public static Servico criarViagem(String codigo, String origem, String destino, LocalDate data, LocalTime horario, LocalTime liberacaoPrevista, Motorista motorista, Veiculo veiculo, Garagem garagem) {
        return new Servico(codigo, origem, destino, data, horario, liberacaoPrevista,motorista, veiculo, garagem);
    }

    // Método para criar uma Garagem
    public static Garagem criarGaragem(String nome, String sigla) {

        return new Garagem(nome, sigla);
    }
}
