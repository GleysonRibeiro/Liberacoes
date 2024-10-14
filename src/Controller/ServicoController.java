package Controller;

import Model.Garagem;
import Model.Motorista;
import Model.Servico;
import Model.Veiculo;
import Service.MotoristaService;
import Service.ServicoService;
import Service.VeiculoService;
import View.GaragemView;
import View.MotoristaView;
import View.ServicoView;
import View.VeiculoView;

import java.time.LocalDateTime;
import java.util.List;

public class ServicoController {

    private final ServicoService servicoService;
    private final ServicoView servicoView;
    private final MotoristaView motoristaView = new MotoristaView();
    private final VeiculoView veiculoView = new VeiculoView();
    private final GaragemView garagemView = new GaragemView();
    private final MotoristaService motoristaService = new MotoristaService();
    private final VeiculoService veiculoService = new VeiculoService();

    public ServicoController(ServicoService servicoService, ServicoView servicoView) {
        this.servicoService = servicoService;
        this.servicoView = servicoView;
    }

    // Método para exibir o menu e processar as opções escolhidas pelo usuário
    public void exibirMenu() {
        boolean rodando = true;

        while (rodando) {

            switch (servicoView.exibirMenu()) {
                case 1:
                    adicionarServico();
                    break;
                case 2:
                    removerServico();
                    break;
                case 3:
                    listarServicos();
                    break;
                case 4:
                    substituirMotorista();
                    break;
                case 5:
                    substituirVeiculo();
                    break;
                case 6:
                    registrarLiberacaoVeiculo();
                    break;
                case 7:
                    registrarJustificativaAtraso();
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

    // Método para adicionar um novo serviço
    private void adicionarServico() {
        Motorista motorista = motoristaView.solicitarDadosMotorista();
        Veiculo veiculo = veiculoView.solicitarDadosVeiculo();
        Garagem garagem = garagemView.solicitarDadosGaragem();
        Servico servico = servicoView.solicitarDadosServico(motorista, veiculo, garagem);
        servicoService.adicionarServico(servico);
        System.out.println("Serviço adicionado com sucesso.");
    }

    // Método para remover um serviço
    private void removerServico() {
        String codigo = servicoView.solicitarCodigoServico();
        boolean removido = servicoService.removerServico(codigo);

        if (removido) {
            System.out.println("Serviço removido com sucesso.");
        } else {
            System.out.println("Serviço não encontrado.");
        }
    }

    // Método para listar todos os serviços cadastrados
    private void listarServicos() {
        List<Servico> servicos = servicoService.listarServicos();
        servicoView.exibirListaServicos(servicos);
    }

    // Método para substituir o motorista de um serviço
    private void substituirMotorista() {
        String codigo = servicoView.solicitarCodigoServico();
        String matricula = motoristaView.solicitarMatriculaMotorista();
        boolean atualizado = servicoService.substituirMotorista(codigo, motoristaService.encontrarMotoristaPorMatricula(matricula));

        if (atualizado) {
            System.out.println("Motorista substituído com sucesso.");
        } else {
            System.out.println("Serviço ou motorista não encontrado.");
        }
    }

    // Método para substituir o veículo de um serviço
    private void substituirVeiculo() {
        String codigo = servicoView.solicitarCodigoServico();
        String placa = veiculoView.solicitarPlacaVeiculo();
        boolean atualizado = servicoService.substituirVeiculo(codigo, veiculoService.buscarVeiculoPorPlaca(placa));

        if (atualizado) {
            System.out.println("Veículo substituído com sucesso.");
        } else {
            System.out.println("Serviço ou veículo não encontrado.");
        }
    }

    // Método para registrar a liberação real de um veículo
    private void registrarLiberacaoVeiculo() {
        String codigo = servicoView.solicitarCodigoServico();
        String liberacaoRealizada = servicoView.solicitarLiberacaoRealizada();

        boolean liberado = servicoService.registrarLiberacao(codigo, liberacaoRealizada);


        if (liberado) {
            System.out.println("Liberação registrada com sucesso.");
        } else {
            System.out.println("Serviço não encontrado.");
        }


    }

    // Método para registrar justificativa de atraso
    private void registrarJustificativaAtraso() {
        String codigo = servicoView.solicitarCodigoServico();
        String justificativa = servicoView.solicitarJustificativaAtraso();

        boolean registrado = servicoService.registrarJustificativaAtraso(codigo, justificativa);

        if (registrado) {
            System.out.println("Justificativa registrada com sucesso.");
        } else {
            System.out.println("Serviço não encontrado.");
        }
    }
}

