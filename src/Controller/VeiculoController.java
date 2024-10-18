package Controller;

import Factory.TransporteFactory;
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
    public Veiculo adicionarVeiculo() {
        String[] dadosVeiculo = veiculoView.solicitarDadosVeiculo();
        Veiculo veiculo = TransporteFactory.criarVeiculo(dadosVeiculo[0], dadosVeiculo[1], Integer.parseInt(dadosVeiculo[2]), dadosVeiculo[3]);
        veiculoService.adicionarVeiculo(veiculo);
        System.out.println("Veículo adicionado com sucesso.");
        return veiculo;
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

    public Veiculo encontrarVeiculoPorPrefixo(String prefixo) {
        Veiculo veiculo = veiculoService.buscarVeiculoPorPrefixo(prefixo);
        if(veiculo==null){
            veiculo = adicionarVeiculo();
        }
        veiculoView.exibirVeiculo(veiculo);
        return veiculo;
    }

    // Método para remover um veículo
    public void removerVeiculo(String placa) {
        veiculoService.removerVeiculo(placa);
    }

    public String solicitarPrefixo(){
        return veiculoView.solicitarPrefixo();
    }



    public void exibirMenu() {
        boolean rodando = true;
        while (rodando) {
            switch (veiculoView.exibirMenu()) {
                case 1:
                    adicionarVeiculo();
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

