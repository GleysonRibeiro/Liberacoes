package Service;

import Model.Motorista;
import Model.Servico;
import Model.Veiculo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ServicoService {

    // Lista para armazenar os serviços criados
    private final List<Servico> servicos;

    // Construtor
    public ServicoService() {
        this.servicos = new ArrayList<>();
    }

    // Método para adicionar um novo serviço
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
        System.out.println("Serviço adicionado com sucesso: " + servico.getCodigo());
    }

    // Método para remover um serviço pelo código
    public boolean removerServico(String codigo) {
        Servico servico = buscarServicoPorCodigo(codigo);
        if (servico != null) {
            servicos.remove(servico);
            System.out.println("Serviço removido: " + codigo);
            return true;
        } else {
            System.out.println("Serviço não encontrado: " + codigo);
            return false;
        }
    }

    // Método para buscar um serviço pelo código
    public Servico buscarServicoPorCodigo(String codigo) {
        for (Servico servico : servicos) {
            if (servico.getCodigo().equals(codigo)) {
                return servico;
            }
        }
        System.out.println("Serviço não encontrado: " + codigo);
        return null;
    }

    // Método para listar todos os serviços
    public List<Servico> listarServicos() {
        return servicos;
    }

    // Método para substituir o motorista de um serviço
    public boolean substituirMotorista(String codigoServico, Motorista novoMotorista) {
        Servico servico = buscarServicoPorCodigo(codigoServico);
        if (servico != null) {
            servico.setMotorista(novoMotorista);
            System.out.println("Motorista substituído para o serviço: " + codigoServico);
            return true;
        }
        else{
            System.out.println("O serviço: " + codigoServico + "não foi encontrado");
            return false;
        }
    }

    // Método para substituir o veículo de um serviço
    public boolean substituirVeiculo(String codigoServico, Veiculo novoVeiculo) {
        Servico servico = buscarServicoPorCodigo(codigoServico);
        if (servico != null) {
            servico.setVeiculo(novoVeiculo);
            System.out.println("Veículo substituído para o serviço: " + codigoServico);
            return true;
        }
        else{
            System.out.println("O serviço: " + codigoServico + "não foi encontrado");
            return false;
        }
    }

    // Método para registrar a liberação de um veículo
    public boolean registrarLiberacao(String codigoServico, String liberacaoRealizada) {
        Servico servico = buscarServicoPorCodigo(codigoServico);
        if (servico != null) {
            servico.liberarVeiculo(LocalTime.parse(liberacaoRealizada));
            System.out.println("Liberação registrada para o serviço: " + codigoServico);
            return true;
        }
        else{
            System.out.println("O serviço: " + codigoServico + "não foi encontrado");
            return false;
        }
    }

    // Método para registrar uma justificativa de atraso
    public boolean registrarJustificativaAtraso(String codigoServico, String justificativa) {
        Servico servico = buscarServicoPorCodigo(codigoServico);
        if (servico != null) {
            servico.registrarJustificativaAtraso(justificativa);
            System.out.println("Justificativa de atraso registrada para o serviço: " + codigoServico);
            return true;
        }
        else{
            System.out.println("O serviço: " + codigoServico + "não foi encontrado");
            return false;
        }
    }

    public LocalTime consultarLiberacaoPrevista(String codigoServico){
        Servico servico = buscarServicoPorCodigo(codigoServico);
        return servico.getLiberacaoPrevista();
    }
}
