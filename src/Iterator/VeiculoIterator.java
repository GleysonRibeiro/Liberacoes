package Iterator;

import Model.Veiculo;

import java.util.Iterator;
import java.util.List;

public class VeiculoIterator implements Iterator<Veiculo> {

    private final List<Veiculo> veiculos;
    private int posicaoAtual;

    // Construtor que recebe a lista de veículos
    public VeiculoIterator(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
        this.posicaoAtual = 0;
    }

    // Verifica se há mais elementos na iteração
    @Override
    public boolean hasNext() {
        return posicaoAtual < veiculos.size();
    }

    // Retorna o próximo veículo na iteração
    @Override
    public Veiculo next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("Não há mais veículos.");
        }
        return veiculos.get(posicaoAtual++);
    }
}

