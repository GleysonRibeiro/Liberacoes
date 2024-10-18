package View;

import Factory.TransporteFactory;
import Model.Motorista;

import java.util.List;
import java.util.Scanner;

public class MotoristaView {
    private final Scanner scanner;

    // Construtor
    public MotoristaView() {
        this.scanner = new Scanner(System.in);  // Criação do Scanner para entrada do teclado
    }

    // Método para exibir todos os motoristas
    public void exibirMotoristas(List<Motorista> motoristas) {
        System.out.println("Lista de Motoristas:");
        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista cadastrado.");
            return;
        }
        for (Motorista motorista : motoristas) {
            System.out.println(motorista);
        }
    }

    // Método para exibir detalhes de um motorista específico
    public void exibirDetalhesMotorista(Motorista motorista) {
        if (motorista != null) {
            System.out.println("Detalhes do Motorista:");
            System.out.println("Nome: " + motorista.getNome());
            System.out.println("Matrícula: " + motorista.getMatricula());
        } else {
            System.out.println("Motorista não encontrado.");
        }
    }

    // Método para exibir uma mensagem de confirmação
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    // Método para solicitar a entrada de um novo motorista
    public String[] solicitarDadosMotorista() {
        System.out.print("Digite o nome do motorista: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matrícula do motorista: ");
        String matricula = scanner.nextLine();

        return new String[] {nome, matricula};
    }
    // Solicita o nome do novo motorista para substituição
    public String solicitarMatriculaMotorista() {
        System.out.print("Informe a matricula do novo motorista: ");
        return scanner.nextLine();
    }

    public int exibirMenu() {

        System.out.println("----- Menu de motorista -----");
        System.out.println("1. Cadastrar motorista");
        System.out.println("2. Remover motorista");
        System.out.println("3. Motoristas cadastrados");
        System.out.println("4. Consultar motorista");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        return Integer.parseInt(scanner.nextLine());
    }

}

