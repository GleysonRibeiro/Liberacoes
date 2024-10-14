package Service;

import Model.Motorista;

import java.util.ArrayList;
import java.util.List;

public class MotoristaService {

    private final List<Motorista> motoristas;

    // Construtor que inicializa a lista de motoristas
    public MotoristaService() {
        motoristas = new ArrayList<>();
    }

    // Método para adicionar um motorista
    public void adicionarMotorista(Motorista motorista) {
        motoristas.add(motorista);
    }

    // Método para listar todos os motoristas
    public List<Motorista> listarMotoristas() {
        return motoristas;
    }

    // Método para encontrar um motorista pelo matrícula
    public Motorista encontrarMotoristaPorMatricula(String matricula) {
        for (Motorista motorista : motoristas) {
            if (motorista.getMatricula().equals(matricula)) {
                return motorista;
            }
        }
        return null; // Retorna null se o motorista não for encontrado
    }

    public void removerMotorista(Motorista motorista) {
        motoristas.remove(motorista);
    }


}

