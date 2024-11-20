import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

// Clase ArraySet que implementa un conjunto utilizando un arreglo
public class ArraySet<T> implements SetADT<T> {
    private final int DEFAULT_CAPACITY = 50; // Capacidad inicial predeterminada
    private final int NOT_FOUND = -1; // -1 indica que no se encontró el elemento
    private int count; // Número de elementos en el conjunto
    private T[] contents; // Arreglo subyacente
    // Constructor que crea un conjunto vacío con capacidad predeterminada
    public ArraySet() {
        count = 0;
        contents = (T[]) (new Object[DEFAULT_CAPACITY]);
    }
    // Constructor que crea un conjunto vacío utilizando la capacidad especificada
    public ArraySet(int initialCapacity) {
        count = 0;
        contents = (T[]) (new Object[initialCapacity]);
    }
    // Agrega un elemento, ignorando duplicados
    public void add(T element) {
        if (!contains(element)) { // Solo agrega si no contiene el elemento
            if (size() == contents.length) { // Duplica el tamaño del arreglo si está lleno
                expandCapacity();
            }
            contents[count] = element; // Agrega el elemento al final
            count++;
        }
    }
    // Duplica la capacidad del arreglo subyacente
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[contents.length * 2]);
        System.arraycopy(contents, 0, larger, 0, contents.length);
        contents = larger;
    }
    // Agrega todos los elementos de un conjunto al actual, ignorando duplicados
    public void addAll(SetADT<T> set) {
        Iterator<T> scan = set.iterator();
        while (scan.hasNext()) { // Itera sobre los elementos del conjunto
            add(scan.next()); // Agrega cada elemento al conjunto actual
        }
    }
    // Elimina y devuelve un elemento de manera aleatoria
    private Random rand = new Random();
    public T removeRandom() throws EmptyStackException {
        if (isEmpty()) { // Lanza excepción si el conjunto está vacío
            throw new EmptyStackException();
        }
        int choice = rand.nextInt(count); // Índice aleatorio
        T result = contents[choice];
        contents[choice] = contents[count - 1]; // Rellena el hueco
        contents[count - 1] = null;
        count--;
        return result;
    }
    // Elimina y devuelve un elemento específico del conjunto
    public T remove(T element) throws EmptyStackException, NoSuchElementException {
        int search = NOT_FOUND; // Índice del elemento buscado
        if (isEmpty()) { // Lanza excepción si el conjunto está vacío
            throw new EmptyStackException();
        }
        for (int index = 0; index < count && search == NOT_FOUND; index++) {
            if (contents[index].equals(element)) { // Busca el elemento
                search = index;
            }
        }
        if (search == NOT_FOUND) { // Lanza excepción si el elemento no está
            throw new NoSuchElementException();
        }
        T result = contents[search];
        contents[search] = contents[count - 1]; // Rellena el hueco
        contents[count - 1] = null;
        count--;
        return result;
    }
    // Devuelve la unión de un conjunto y el actual
    public SetADT<T> union(SetADT<T> set) {
        ArraySet<T> both = new ArraySet<>();
        both.addAll(this); // Agrega todos los elementos del conjunto actual
        both.addAll(set);  // Agrega todos los elementos del conjunto dado
        return both;
    }
    // Devuelve true si el conjunto contiene un elemento específico
    public boolean contains(T target) {
        int search = NOT_FOUND;
        for (int i = 0; i < count && search == NOT_FOUND; i++) {
            if (contents[i].equals(target)) { // Busca el elemento en el arreglo
                search = i;
            }
        }
        return search != NOT_FOUND;
    }
    // Devuelve true si el conjunto y el parámetro contienen exactamente los mismos valores
    public boolean equals(SetADT<T> set) {
        if (size() != set.size()) { // Verifica si tienen el mismo tamaño
            return false;
        }
        Iterator<T> scan = set.iterator();
        while (scan.hasNext()) { // Verifica si todos los elementos coinciden
            if (!contains(scan.next())) {
                return false;
            }
        }
        return true;
    }
    // Devuelve true si el conjunto no contiene ningún elemento
    public boolean isEmpty() {
        return count == 0;
    }
    // Devuelve el número de elementos en el conjunto
    public int size() {
        return count;
    }
    // Proporciona un medio para iterar a través de la colección
    public Iterator<T> iterator() {
        return new ArrayIterator<>(count, contents);
    }
    // Devuelve la representación del conjunto en forma de cadena de caracteres
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(contents[i].toString()).append("\n");
        }
        return result.toString();
    }
}
