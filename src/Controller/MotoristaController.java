package Controller;

import Factory.TransporteFactory;
import Model.Motorista;
import Service.MotoristaService;
import View.MotoristaView;

import java.util.List;

public class MotoristaController {

    private final MotoristaService motoristaService;
    private final MotoristaView motoristaView;

    // Construtor que inicializa o serviço e a visualização
    public MotoristaController(MotoristaService motoristaService, MotoristaView motoristaView) {
        this.motoristaService = motoristaService;
        this.motoristaView = motoristaView;
    }

    // Método para adicionar um motorista
    public Motorista adicionarMotorista() {
        String[] dadosMotorista = motoristaView.solicitarDadosMotorista();
        Motorista motorista = TransporteFactory.criarMotorista(dadosMotorista[0], dadosMotorista[1]);
        motoristaService.adicionarMotorista(motorista);
        motoristaView.exibirMensagem("Motorista adicionado com sucesso!");
    }

    // Método para listar todos os motoristas
    public void listarMotoristas() {
        List<Motorista> motoristas = motoristaService.listarMotoristas();
        motoristaView.exibirMotoristas(motoristas);
    }

    // Método para encontrar e exibir detalhes de um motorista
    public Motorista encontrarMotorista(String matricula) {

        Motorista motorista = motoristaService.encontrarMotoristaPorMatricula(matricula);
        if(motorista==null){
            motorista = adicionarMotorista();
        }
        motoristaView.exibirDetalhesMotorista(motorista);
        return motorista;
    }

    public String solicitarMatricula(){
       return motoristaView.solicitarMatriculaMotorista();
    }

    public void removerMotorista(String matricula){
        motoristaService.removerMotorista(motoristaService.encontrarMotoristaPorMatricula(matricula));
    }

    public void exibirMenu(){
        boolean rodando = true;
        while (rodando) {
            switch (motoristaView.exibirMenu()) {
                case 1:
                    adicionarMotorista();
                    break;
                case 2:
                    removerMotorista(motoristaView.solicitarMatriculaMotorista());
                    break;
                case 3:
                    listarMotoristas();
                    break;
                case 4:
                    encontrarMotorista(motoristaView.solicitarMatriculaMotorista());
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

