import Controller.MainController;
import Controller.ServicoController;

public class Main {
    public static void main(String[] args) {

        AppInitializer initializer = new AppInitializer();
        initializer.iniciar();

        MainController mainController = initializer.getMainController();

        mainController.exibirMenuPrincipal(initializer.getCelularController(), initializer.getGaragemController(), initializer.getMotoristaController(), initializer.getServicoController(), initializer.getVeiculoController());
        //teste git
    }
}
