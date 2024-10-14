package Service;

import Model.Garagem;

import java.util.ArrayList;
import java.util.List;

public class GaragemService {
    private final List<Garagem> garagens;

    // Construtor
    public GaragemService() {
        this.garagens = new ArrayList<>();
    }

    // Método para adicionar uma nova garagem
    public void adicionarGaragem(Garagem garagem) {
        garagens.add(garagem);
    }

    // Método para listar todas as garagens
    public List<Garagem> listarGaragens() {
        return garagens;
    }

    // Método para encontrar uma garagem por sigla
    public Garagem encontrarGaragemPorSigla(String sigla) {
        for (Garagem garagem : garagens) {
            if (garagem.getSigla().equalsIgnoreCase(sigla)) {
                return garagem;
            }
        }
        return null; // Retorna null se a garagem não for encontrada
    }

    public void removerGaragem(String sigla){
        Garagem g = encontrarGaragemPorSigla(sigla);
        garagens.remove(g);
    }
}
