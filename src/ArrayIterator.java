import java.util.Iterator;
import java.util.NoSuchElementException;
// Clase ArrayIterator para iterar sobre los elementos del conjunto
public class ArrayIterator<T> implements Iterator<T> {
    private int current; // índice actual en el recorrido
    private final int count; // cantidad de elementos en el arreglo
    private final T[] items; // referencia al arreglo subyacente
    // Constructor para inicializar el iterador
    public ArrayIterator(int count, T[] items) {
        this.current = 0;
        this.count = count;
        this.items = items;
    }
    // Indica si hay más elementos por iterar
    @Override
    public boolean hasNext() {
        return current < count;
    }
    // Devuelve el siguiente elemento en la iteración
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return items[current++];
    }
    // Este iterador no soporta la operación de eliminación
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove no es compatible con este iterador.");
    }
}