package Controller;

import Factory.TransporteFactory;
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
    public Garagem adicionarGaragem() {
        String[] dadosGaragem = garagemView.solicitarDadosGaragem();
        Garagem novaGaragem = TransporteFactory.criarGaragem(dadosGaragem[0], dadosGaragem[1]);
        garagemService.adicionarGaragem(novaGaragem);
        System.out.println("Garagem adicionada com sucesso!");
        return novaGaragem;
    }

    // Método para listar todas as garagens
    public void listarGaragens() {
        List<Garagem> garagens = garagemService.listarGaragens();
        garagemView.exibirGaragens(garagens);
    }

    // Método para encontrar e exibir uma garagem pela sigla
    public Garagem encontrarGaragemPorSigla(String sigla) {
        Garagem garagem = garagemService.encontrarGaragemPorSigla(sigla);
        if (garagem == null) {
            garagem = adicionarGaragem();
        }
        garagemView.exibirGaragem(garagem);
        return garagem;
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

    public String solicitarSigla(){
        return garagemView.solicitarSiglaGaragem();
    }



}

