package View;

import Model.Garagem;

import java.util.List;
import java.util.Scanner;

public class GaragemView {
    private final Scanner scanner;

    // Construtor
    public GaragemView() {

        this.scanner = new Scanner(System.in);
    }


    // Método para exibir a lista de garagens
    public void exibirGaragens(List<Garagem> garagens) {
        System.out.println("Lista de Garagens:");
        if (garagens.isEmpty()) {
            System.out.println("Nenhuma garagem cadastrada.");
        } else {
            for (Garagem garagem : garagens) {
                System.out.println(garagem);
            }
        }
    }

    // Método para solicitar a entrada de uma nova garagem
    public String[] solicitarDadosGaragem() {
        System.out.print("Digite o nome da garagem: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a sigla da garagem: ");
        String sigla = scanner.nextLine();
        return new String[] {nome, sigla};
    }

    // Método para exibir mensagem de garagem não encontrada
    public void exibirGaragemNaoEncontrada(String sigla) {
        System.out.println("Garagem com sigla '" + sigla + "' não encontrada.");
    }

    // Método para exibir uma garagem específica
    public void exibirGaragem(Garagem garagem) {
        System.out.println("Detalhes da Garagem:");
        System.out.println(garagem);
    }

    public String solicitarSiglaGaragem() {
        System.out.print("Digite a sigla da garagem: ");
        return scanner.nextLine();
    }

    // Método para exibir o menu da view de garagens
    public int exibirMenu() {

        System.out.println("----- Menu de Garagens -----");
        System.out.println("1. Listar Garagens Cadastradas");
        System.out.println("2. Cadastrar Nova Garagem");
        System.out.println("3. Remover uma Garagem");
        System.out.println("4. Consultar garagem");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        return Integer.parseInt(scanner.nextLine());
    }
}

