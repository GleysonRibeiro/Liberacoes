package View;

import Model.Celular;


import java.util.List;
import java.util.Scanner;

public class CelularView {
    private final Scanner scanner;


    // Construtor
    public CelularView() {
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir a lista de celulares
    public void exibirCelulares(List<Celular> celulares) {
        System.out.println("Lista de Celulares:");
        if (celulares.isEmpty()) {
            System.out.println("Nenhum celular cadastrado.");
        } else {
            for (Celular celular : celulares) {
                System.out.println(celular);
            }
        }
    }

    // Método para solicitar a entrada de um novo celular
    public String[] solicitarDadosCelular() {
        System.out.print("Digite o código do celular: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o número do celular: ");
        String numero = scanner.nextLine();
        System.out.print("Digite a marca do celular: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo do celular: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite a situação do celular (disponível/indisponível): ");
        String situacao = scanner.nextLine();



        return new String[]{codigo, numero, marca, modelo, situacao};
    }

    public String solicitarCodigoCelular() {
        System.out.print("Digite o código do celular: ");
        return scanner.nextLine();
    }

    // Método para exibir mensagem de celular não encontrado
    public void exibirCelularNaoEncontrado(String numero) {
        System.out.println("Celular com número '" + numero + "' não encontrado.");
    }

    // Método para exibir um celular específico
    public void exibirCelular(Celular celular) {
        System.out.println("Detalhes do Celular:");
        System.out.println(celular);
    }

    //Método para menu de celulares
    public int exibirMenu() {
        System.out.println("----- Gerenciamento de Celulares -----");
        System.out.println("1. Adicionar novo celular");
        System.out.println("2. Remover celular");
        System.out.println("3. Listar todos os celulares");
        System.out.println("4. Consultar celular");
        System.out.println("0. Tela inicial");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }
}

