package Service;

import Model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoService {

    // Lista que armazenará os veículos em memória
    private final List<Veiculo> veiculos;

    // Construtor que inicializa a lista de veículos
    public VeiculoService() {
        this.veiculos = new ArrayList<>();
    }

    // Método para adicionar um veículo
    public void adicionarVeiculo(Veiculo veiculo) {
        if (!veiculoJaExiste(veiculo.getPlaca())) {
            veiculos.add(veiculo);
            System.out.println("Veículo adicionado com sucesso!");
        } else {
            System.out.println("Veículo com a placa " + veiculo.getPlaca() + " já existe.");
        }
    }

    // Método para remover um veículo
    public boolean removerVeiculo(String placa) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            System.out.println("Veículo removido com sucesso!");
            return true;
        } else {
            System.out.println("Veículo não encontrado.");
            return false;
        }
    }

    // Método para atualizar os dados de um veículo
    public boolean atualizarVeiculo(String placa, String novoPrefixo, int novaCapacidade, String novoTipo) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculo.setPrefixo(novoPrefixo);
            veiculo.setCapacidade(novaCapacidade);
            veiculo.setTipo(novoTipo);
            System.out.println("Veículo atualizado com sucesso!");
            return true;
        } else {
            System.out.println("Veículo não encontrado.");
            return false;
        }
    }

    // Método para listar todos os veículos cadastrados
    public List<Veiculo> listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        }
        return veiculos;
    }

    // Método auxiliar para buscar um veículo pela placa
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    // Verifica se o veículo já está cadastrado com base na placa
    private boolean veiculoJaExiste(String placa) {
        return buscarVeiculoPorPlaca(placa) != null;
    }

    // Método para exibir a lista de veículos
    public void exibirVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            for (Veiculo veiculo : veiculos) {
                veiculo.exibirInformacoes();
                System.out.println();
            }
        }
    }

}

