package View;

import Model.Veiculo;
import java.util.List;
import java.util.Scanner;
import Factory.TransporteFactory;

public class VeiculoView {
    private final Scanner scanner;

    // Construtor
    public VeiculoView() {
        this.scanner = new Scanner(System.in);  // Scanner para entrada de dados
    }

    // Método para exibir as informações de um único veículo
    public void exibirVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            System.out.println("Veículo:");
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Prefixo: " + veiculo.getPrefixo());
            System.out.println("Capacidade: " + veiculo.getCapacidade());
            System.out.println("Tipo: " + veiculo.getTipo());
            System.out.println();
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    // Método para exibir uma lista de veículos
    public void exibirVeiculos(List<Veiculo> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            for (Veiculo veiculo : veiculos) {
                exibirVeiculo(veiculo);
            }
        }
    }

    // Método para solicitar a entrada de dados para um novo veículo
    public Veiculo solicitarDadosVeiculo() {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o prefixo do veículo: ");
        String prefixo = scanner.nextLine();
        System.out.print("Digite a capacidade do veículo: ");
        int capacidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o tipo do veículo: ");
        String tipo = scanner.nextLine();

        // Criar veículo utilizando a fábrica (TransporteFactory)
        return TransporteFactory.criarVeiculo(placa, prefixo, capacidade, tipo);
    }

    // Solicita a placa do novo veículo para substituição
    public String solicitarPlacaVeiculo() {
        System.out.print("Informe a placa do novo veículo: ");
        return scanner.nextLine();
    }

    public int exibirMenu() {

        System.out.println("----- Menu de veículo -----");
        System.out.println("1. Cadastrar veículo");
        System.out.println("2. Remover veículo");
        System.out.println("3. Veículos cadastrados");
        System.out.println("4. Consultar veículo");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        return Integer.parseInt(scanner.nextLine());
    }
}

