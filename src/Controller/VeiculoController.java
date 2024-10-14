package Controller;

import Model.Veiculo;
import Service.VeiculoService;
import View.VeiculoView;

import java.util.List;

public class VeiculoController {

    private final VeiculoService veiculoService;
    private final VeiculoView veiculoView;

    // Construtor que inicializa o serviço e a visão
    public VeiculoController(VeiculoService veiculoService, VeiculoView veiculoView) {
        this.veiculoService = veiculoService;
        this.veiculoView = veiculoView;
    }

    // Método para adicionar um veículo
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculoService.adicionarVeiculo(veiculo);
        System.out.println("Veículo adicionado com sucesso.");
    }

    // Método para listar todos os veículos
    public void listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        veiculoView.exibirVeiculos(veiculos);
    }

    // Método para encontrar um veículo pela placa
    public void encontrarVeiculoPorPlaca(String placa) {
        Veiculo veiculo = veiculoService.buscarVeiculoPorPlaca(placa);
        veiculoView.exibirVeiculo(veiculo);
    }

    // Método para remover um veículo
    public void removerVeiculo(String placa) {
        veiculoService.removerVeiculo(placa);
    }



    public void exibirMenu() {
        boolean rodando = true;
        while (rodando) {
            switch (veiculoView.exibirMenu()) {
                case 1:
                    adicionarVeiculo(veiculoView.solicitarDadosVeiculo());
                    break;
                case 2:
                    removerVeiculo(veiculoView.solicitarPlacaVeiculo());
                    break;
                case 3:
                    listarVeiculos();
                    break;
                case 4:
                    encontrarVeiculoPorPlaca(veiculoView.solicitarPlacaVeiculo());
                    break;
                case 0:
                    rodando = false;
                    System.out.println("Retornando a tela inicial...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}

