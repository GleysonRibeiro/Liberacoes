package Controller;

import Model.Garagem;
import Service.GaragemService;
import View.GaragemView;

import java.util.List;

public class GaragemController {
    private final GaragemService garagemService;
    private final GaragemView garagemView;

    // Construtor
    public GaragemController(GaragemService garagemService, GaragemView garagemView) {
        this.garagemService = garagemService;
        this.garagemView = garagemView;
    }

    // Método para adicionar uma nova garagem
    public void adicionarGaragem() {
        Garagem novaGaragem = garagemView.solicitarDadosGaragem();
        garagemService.adicionarGaragem(novaGaragem);
        System.out.println("Garagem adicionada com sucesso!");
    }

    // Método para listar todas as garagens
    public void listarGaragens() {
        List<Garagem> garagens = garagemService.listarGaragens();
        garagemView.exibirGaragens(garagens);
    }

    // Método para encontrar e exibir uma garagem pela sigla
    public void encontrarGaragemPorSigla(String sigla) {
        Garagem garagem = garagemService.encontrarGaragemPorSigla(sigla);
        if (garagem != null) {
            garagemView.exibirGaragem(garagem);
        } else {
            garagemView.exibirGaragemNaoEncontrada(sigla);
        }
    }

    public void removerGaragem(){
        garagemService.removerGaragem(garagemView.solicitarSiglaGaragem());
    }

    public void exibirMenu(){
        boolean rodando = true;
        while (rodando) {
            switch (garagemView.exibirMenu()) {
                case 1:
                    adicionarGaragem();
                    break;
                case 2:
                    removerGaragem();
                    break;
                case 3:
                    listarGaragens();
                    break;
                case 4:
                    encontrarGaragemPorSigla(garagemView.solicitarSiglaGaragem());
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

