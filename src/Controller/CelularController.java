package Controller;

import Factory.TransporteFactory;
import Model.Celular;
import Service.CelularService;
import View.CelularView;

import java.util.List;

public class CelularController {
    private final CelularService celularService;
    private final CelularView celularView;

    // Construtor
    public CelularController(CelularService celularService, CelularView celularView) {
        this.celularService = celularService;
        this.celularView = celularView;
    }

    // Método para adicionar um novo celular
    public void adicionarCelular() {
        String[] dadosCelular = celularView.solicitarDadosCelular();
        Celular novoCelular = TransporteFactory.criarCelular(dadosCelular[0], dadosCelular[1], dadosCelular[2], dadosCelular[3], dadosCelular[4] ,null);
        celularService.adicionarCelular(novoCelular);
        System.out.println("Celular adicionado com sucesso!");
    }

    public void removerCelular() {
        celularService.removerCelular(celularView.solicitarCodigoCelular());
        System.out.println("Celular removido com sucesso!");
    }

    // Método para listar todos os celulares
    public void listarCelulares() {
        List<Celular> celulares = celularService.listarCelulares();
        celularView.exibirCelulares(celulares);
    }

    // Método para encontrar e exibir um celular pelo código
    public void encontrarCelularPorCodigo(String codigo) {
        Celular celular = celularService.encontrarCelularPorCodigo(codigo);
        if (celular != null) {
            celularView.exibirCelular(celular);
        } else {
            celularView.exibirCelularNaoEncontrado(codigo);
        }
    }

    public void exibirMenu() {
        boolean rodando = true;

        while (rodando) {

            switch (celularView.exibirMenu()) {
                case 1:
                    adicionarCelular();
                    break;
                case 2:
                    removerCelular();
                    break;
                case 3:
                    listarCelulares();
                    break;
                case 4:
                    encontrarCelularPorCodigo(celularView.solicitarCodigoCelular());
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

