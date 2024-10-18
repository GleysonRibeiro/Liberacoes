package View;

import Factory.TransporteFactory;
import Model.Garagem;
import Model.Motorista;
import Model.Servico;
import Model.Veiculo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;


public class ServicoView {

    private final Scanner scanner;

    public ServicoView() {
        scanner = new Scanner(System.in);
    }

    // Exibe o menu principal de opções para o usuário
    public int exibirMenu() {
        System.out.println("----- Sistema de Gerenciamento de Serviços -----");
        System.out.println("1. Adicionar novo serviço");
        System.out.println("2. Remover serviço");
        System.out.println("3. Listar todos os serviços");
        System.out.println("4. Substituir motorista");
        System.out.println("5. Substituir veículo");
        System.out.println("6. Registrar liberação de veículo");
        System.out.println("7. Registrar justificativa de atraso");
        System.out.println("0. Tela inicial");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }


    // Exibe os detalhes de um serviço específico
    public void exibirDetalhesServico(Servico servico) {
        System.out.println("----- Detalhes do Serviço -----");
        System.out.println("Código: " + servico.getCodigo());
        System.out.println("Origem: " + servico.getOrigem());
        System.out.println("Destino: " + servico.getDestino());
        System.out.println("Horário: " + servico.getHorario());
        System.out.println("Liberação Prevista: " + servico.getLiberacaoPrevista());
        System.out.println("Liberação Realizada: " + (servico.getLiberacaoRealizada() != null ? servico.getLiberacaoRealizada() : "Ainda não realizada"));
        System.out.println("Motorista: " + servico.getMotorista().getNome());
        System.out.println("Veículo: " + servico.getVeiculo().getPlaca());
        System.out.println("Garagem de Liberação: " + servico.getGaragemLiberacao().getNome());
        if (servico.getJustificativaAtraso() != null) {
            System.out.println("Justificativa de Atraso: " + servico.getJustificativaAtraso());
        }
    }

    // Exibe a lista de todos os serviços cadastrados
    public void exibirListaServicos(List<Servico> servicos) {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
        } else {
            System.out.println("----- Lista de Serviços -----");
            for (Servico servico : servicos) {
                System.out.println(servico.getCodigo() + "| " + servico.getOrigem() + " -> " + servico.getDestino() + " -> " + servico.getHorario() + " -> " + servico.getMotorista() + " -> " + servico.getVeiculo().getPrefixo());
            }
        }
    }

    // Solicita ao usuário as informações para adicionar um novo serviço
    public String[] solicitarDadosServico() {
        System.out.println("----- Adicionar Novo Serviço -----");

        System.out.print("Código do serviço: ");
        String codigo = scanner.nextLine();

        System.out.print("Origem: ");
        String origem = scanner.nextLine();

        System.out.print("Destino: ");
        String destino = scanner.nextLine();

        return new String[] {codigo, origem, destino};
    }

    // Método para solicitar a data com tratamento de erro
    public LocalDate solicitarData() {
        LocalDate data = null;
        boolean dataValida = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (!dataValida) {
            System.out.print("Data (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();

            try {
                data = LocalDate.parse(dataStr, formatter);
                dataValida = true; // Se o parse for bem-sucedido, sai do loop
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. O formato correto é dd/MM/yyyy.");
            }
        }
        return data;
    }

    // Método para solicitar horário com tratamento de erro
    public LocalTime solicitarHorario(String mensagem) {
        LocalTime horario = null;
        boolean horarioValido = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (!horarioValido) {
            System.out.print(mensagem);
            String horarioStr = scanner.nextLine();

            try {
                horario = LocalTime.parse(horarioStr, formatter);
                horarioValido = true; // Se o parse for bem-sucedido, sai do loop
            } catch (DateTimeParseException e) {
                System.out.println("Horário inválido. O formato correto é HH:mm.");
            }
        }
        return horario;
    }

    // Solicita o código do serviço para realizar operações nele
    public String solicitarCodigoServico() {
        System.out.print("Informe o código do serviço: ");
        return scanner.nextLine();
    }


    // Solicita a hora real de liberação para o serviço
    public String solicitarLiberacaoRealizada() {
        System.out.print("Informe o horário de liberação realizado: ");
        return scanner.nextLine();
    }

    // Solicita a justificativa de atraso do usuário
    public String solicitarJustificativaAtraso() {
        System.out.print("Informe a justificativa de atraso: ");
        return scanner.nextLine();
    }
}
