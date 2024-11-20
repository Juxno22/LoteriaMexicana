import java.util.Iterator;
public class Loteria {
    private ArraySet<String> cartas; // Conjunto para almacenar las cartas de la lotería mexicana
    // Constructor que inicializa el conjunto de cartas
    public Loteria() {
        cartas = new ArraySet<>();
    }
    // Método para agregar las cartas de la lotería mexicana al conjunto
    public void agregarCartas() {
        // Arreglo con los nombres de las cartas de la lotería mexicana
        String[] nombresCartas = {
                "El Gallo", "El Diablito", "La Dama", "El Catrín", "El Paraguas",
                "La Sirena", "La Escalera", "La Botella", "El Barril", "El Árbol",
                "El Melón", "El Valiente", "El Gorrito", "La Muerte", "La Pera",
                "La Bandera", "El Sol", "La Luna", "El Cotorro", "El Borracho",
                "El Negrito", "El Corazón", "La Sandía", "El Tambor", "El Camarón",
                "Las Jaras", "El Músico", "La Rosa", "La Calavera", "La Campana",
                "El Cantarito", "El Venado", "El Mundo", "El Apache", "El Nopal",
                "El Alacrán", "La Rana", "El Arpa", "La Palma", "La Maceta",
                "El Violoncello", "La Garza", "El Pescado", "La Estrella", "El Mano",
                "La Chalupa", "El Pino", "El Paraguas", "El Sol", "La Corona"
        };
        // Recorremos el arreglo y agregamos cada carta al conjunto
        for (int i = 0; i < nombresCartas.length; i++) {
            cartas.add(nombresCartas[i]); // Método `add` evita duplicados automáticamente
        }
    }
    // Método para imprimir todas las cartas agregadas al conjunto
    public void imprimirCartas() {
        System.out.println("Cartas en el conjunto:");
        Iterator<String> it = cartas.iterator(); // Obtenemos un iterador para recorrer las cartas
        while (it.hasNext()) { // Mientras haya elementos en el conjunto
            System.out.println(it.next()); // Imprimimos la carta actual
        }
    }
    // Método para imprimir las cartas en un orden aleatorio
    public void imprimirCartasAleatorias() {
        System.out.println("Cartas en orden aleatorio:");
        // Creamos una copia del conjunto original para no modificarlo
        ArraySet<String> copiaCartas = new ArraySet<>();
        copiaCartas.addAll(cartas); // Agregamos todas las cartas al conjunto copiado
        // Mientras la copia no esté vacía
        while (!copiaCartas.isEmpty()) {
            // Removemos e imprimimos una carta al azar
            System.out.println(copiaCartas.removeRandom());
        }
    }
    public static void main(String[] args) {
        Loteria loteria = new Loteria(); // Creamos una instancia de la clase Loteria
        loteria.agregarCartas(); // Agregamos las cartas de la lotería al conjunto
        // Imprimimos las cartas en el orden en que fueron agregadas
        System.out.println("=== Impresión de Cartas ===");
        loteria.imprimirCartas();
        // Imprimimos las cartas en un orden aleatorio
        System.out.println("\n=== Impresión de Cartas Aleatorias ===");
        loteria.imprimirCartasAleatorias();
    }
}
