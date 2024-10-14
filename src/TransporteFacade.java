import Factory.TransporteFactory;
import Model.Celular;
import Model.Motorista;
import Model.Veiculo;
import Model.Garagem;
import Service.*;
import Model.Servico;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransporteFacade {
    private final CelularService celularService;
    private final MotoristaService motoristaService;
    private final VeiculoService veiculoService;
    private final ServicoService servicoService;
    private final GaragemService garagemService;

    // Construtor inicializando todos os serviços
    public TransporteFacade() {
        this.celularService = new CelularService();
        this.motoristaService = new MotoristaService();
        this.veiculoService = new VeiculoService();
        this.servicoService = new ServicoService();
        this.garagemService = new GaragemService();
    }

    // Métodos do Facade para operações comuns

    // 1. Adicionar novo motorista
    public void adicionarMotorista(String nome, String matricula) {
        Motorista motorista = TransporteFactory.criarMotorista(nome, matricula);
        motoristaService.adicionarMotorista(motorista);
    }

    // 2. Adicionar novo veículo
    public void adicionarVeiculo(String placa, String prefixo, int capacidade, String tipo) {
        Veiculo veiculo = TransporteFactory.criarVeiculo(placa, prefixo, capacidade, tipo);
        veiculoService.adicionarVeiculo(veiculo);
    }

    // 3. Adicionar novo celular
    public void adicionarCelular(String codigo, String numero, String marca, String modelo, String situacao, Motorista motorista) {
        Celular celular = TransporteFactory.criarCelular(codigo, numero, marca, modelo, situacao, motorista);
        celularService.adicionarCelular(celular);
    }

    // 4. Agendar uma viagem
    public void agendarViagem(String codigo, String origem, String destino, LocalDate data, LocalTime horario, LocalTime liberacaoPrevista, Motorista motorista, Veiculo veiculo, Garagem garagem) {
        Servico servico = TransporteFactory.criarViagem(codigo, origem, destino, data, horario, liberacaoPrevista, motorista, veiculo, garagem);
        servicoService.adicionarServico(servico); // Alterado para usar servicoService
    }


    // 7. Listar todos os motoristas
    public void listarMotoristas() {
        motoristaService.listarMotoristas().forEach(motorista -> {
            System.out.println(motorista.getNome());
        });
    }

    // 8. Listar todos os veículos
    public void listarVeiculos() {
        veiculoService.listarVeiculos().forEach(veiculo -> {
            System.out.println(veiculo.getPrefixo());
        });
    }

    // 9. Listar todos os celulares
    public void listarCelulares() {
        celularService.listarCelulares().forEach(celular -> {
            System.out.println(celular.getCodigo());
        });
    }

    // 10. Listar todas as garagens
    public void listarGaragens() {
        garagemService.listarGaragens().forEach(garagem -> {
            System.out.println(garagem.getNome());
        });
    }
}


