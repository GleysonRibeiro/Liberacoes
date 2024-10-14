package View;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner;

    private final ServicoView servicoView = new ServicoView();
    private final CelularView celularView = new CelularView();
    private final GaragemView garagemView = new GaragemView();
    private final MotoristaView motoristaView = new MotoristaView();
    private final VeiculoView veiculoView = new VeiculoView();

    // Construtor
    public MainView() {
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir o menu principal
    public int exibirMenu() {

            System.out.println("----- Menu Principal -----");
            System.out.println("1. Serviços");
            System.out.println("2. Garagens");
            System.out.println("3. Motoristas");
            System.out.println("4. Veículos");
            System.out.println("5. Celulares");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            return Integer.parseInt(scanner.nextLine());

    }
}
