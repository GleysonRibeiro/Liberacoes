package Service;

import Model.Celular;
import Model.Motorista;

import java.util.ArrayList;
import java.util.List;

public class CelularService {
    // Lista para armazenar os objetos Celular
    private final List<Celular> celulares;

    // Construtor inicializa a lista de celulares
    public CelularService() {
        this.celulares = new ArrayList<>();
    }

    // Método para adicionar um celular à lista
    public void adicionarCelular(Celular celular) {
        celulares.add(celular);
        System.out.println("Celular adicionado: " + celular.getNumero());
    }

    // Método para remover um celular da lista
    public void removerCelular(String codigo) {
        Celular celularARemover = encontrarCelularPorCodigo(codigo);
        if (celularARemover != null) {
            celulares.remove(celularARemover);
            System.out.println("Celular removido: " + codigo);
        } else {
            System.out.println("Celular não encontrado.");
        }
    }

    // Método para encontrar um celular pelo código
    public Celular encontrarCelularPorCodigo(String codigo) {
        for (Celular celular : celulares) {
            if (celular.getCodigo().equals(codigo)) {
                return celular;
            }
        }
        return null;
    }

    // Método para atualizar as informações de um celular
    public void atualizarCelular(String codigo, String novoNumero, String novaMarca, String novoModelo, String novaSituacao, Motorista novoMotorista) {
        Celular celular = encontrarCelularPorCodigo(codigo);
        if (celular != null) {
            celular.setNumero(novoNumero);
            celular.setMarca(novaMarca);
            celular.setModelo(novoModelo);
            celular.setSituacao(novaSituacao);
            celular.setMotorista(novoMotorista);
            System.out.println("Celular atualizado: " + codigo);
        } else {
            System.out.println("Celular não encontrado.");
        }
    }

    // Método para listar todos os celulares
    public List<Celular> listarCelulares() {
        return celulares;
    }
}

