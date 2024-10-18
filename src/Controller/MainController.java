package Controller;

import View.MainView;

public class MainController {

    private final MainView mainView;

    public MainController(MainView m){
        mainView = m;
    }

    public void exibirMenuPrincipal(CelularController celularController, GaragemController garagemController, MotoristaController motoristaController, ServicoController servicoController, VeiculoController veiculoController){

        while(true) {
            switch (mainView.exibirMenu()) {
                case 1:
                    servicoController.exibirMenu(garagemController, motoristaController, veiculoController);
                    break;
                case 2:
                    garagemController.exibirMenu();
                    break;
                case 3:
                    motoristaController.exibirMenu();
                    break;
                case 4:
                    veiculoController.exibirMenu();
                    break;
                case 5:
                    celularController.exibirMenu();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return; // Encerra o loop
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



}
