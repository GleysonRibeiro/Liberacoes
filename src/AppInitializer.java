import Controller.*;
import Service.*;
import View.*;

public class AppInitializer {
    private TransporteFacade facade;

    // Controllers
    private CelularController celularController;
    private MotoristaController motoristaController;
    private VeiculoController veiculoController;
    private GaragemController garagemController;
    private ServicoController servicoController;
    private MainController mainController;

    public void iniciar() {
        // Inicializa os serviços
        CelularService celularService = new CelularService();
        MotoristaService motoristaService = new MotoristaService();
        VeiculoService veiculoService = new VeiculoService();
        ServicoService servicoService = new ServicoService();
        GaragemService garagemService = new GaragemService();

        // Inicializa as views
        CelularView celularView = new CelularView();
        MotoristaView motoristaView = new MotoristaView();
        VeiculoView veiculoView = new VeiculoView();
        GaragemView garagemView = new GaragemView();
        ServicoView servicoView = new ServicoView();
        MainView mainView = new MainView();

        // Inicializa os controllers
        celularController = new CelularController(celularService, celularView);
        motoristaController = new MotoristaController(motoristaService, motoristaView);
        veiculoController = new VeiculoController(veiculoService, veiculoView);
        garagemController = new GaragemController(garagemService, garagemView);
        servicoController = new ServicoController(servicoService, servicoView);
        mainController = new MainController(mainView);

        // Inicializa a facade
        facade = new TransporteFacade();
    }

    // Métodos para obter os controllers
    public CelularController getCelularController() {
        return celularController;
    }

    public MotoristaController getMotoristaController() {

        return motoristaController;
    }

    public VeiculoController getVeiculoController() {

        return veiculoController;
    }

    public GaragemController getGaragemController() {

        return garagemController;
    }

    public ServicoController getServicoController() {

        return servicoController;
    }

    public MainController getMainController(){

        return mainController;
    }

    // Se necessário, adicione um método para obter a facade
    public TransporteFacade getFacade() {
        return facade;
    }
}

