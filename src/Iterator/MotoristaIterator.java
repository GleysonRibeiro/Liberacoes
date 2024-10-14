package Iterator;

import Model.Motorista;

import java.util.Iterator;
import java.util.List;

public class MotoristaIterator implements Iterator<Motorista> {

    private final List<Motorista> motoristas;
    private int position = 0;

    // Construtor que recebe a lista de motoristas
    public MotoristaIterator(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    // Verifica se há um próximo motorista na lista
    @Override
    public boolean hasNext() {
        return position < motoristas.size();
    }

    // Retorna o próximo motorista
    @Override
    public Motorista next() {
        if (!hasNext()) {
            throw new IllegalStateException("Não há mais motoristas na lista.");
        }
        return motoristas.get(position++);
    }

    // Reseta a posição do iterador
    public void reset() {
        position = 0;
    }
}

