public class Grafo {

    private NodoGrafo cabeza;

    public Grafo() {
        this.cabeza = null;
    }

    public void agregarLibro(Libro libro) {

        if (buscarNodo(libro.getCodigo()) != null) {
            System.out.println( "Ya existe un libro con el codigo: " + libro.getCodigo() );
            return;
        }
        NodoGrafo nuevoNodo = new NodoGrafo(libro);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoGrafo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    private NodoGrafo buscarNodo(String codigo) {
        NodoGrafo actual = cabeza;
        while (actual != null) {
            if (actual.getLibro().getCodigo().equals(codigo)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void agregarRelacion( String codigo1, String codigo2) {
        if (codigo1.equals(codigo2)) {
            System.out.println(
                "Un libro no puede relacionarse consigo mismo."
            );
            return;
        }
        NodoGrafo libro1 = buscarNodo(codigo1);
        NodoGrafo libro2 = buscarNodo(codigo2);
        if (libro1 == null || libro2 == null) {
            System.out.println("Uno o ambos libros no existen en el grafo.");
            return;
        }
        if (existeAdyacencia(libro1, codigo2)) {
            System.out.println("La relacion ya existe.");
            return;
        }

        agregarAdyacencia(libro1, codigo2);
        agregarAdyacencia(libro2, codigo1);
    }

    private void agregarAdyacencia(NodoGrafo nodo, String codigoVecino) {

        NodoAdyacencia nuevo = new NodoAdyacencia(codigoVecino);

        if (nodo.getAdyacencias() == null) {
            nodo.setAdyacencias(nuevo);
        } else {
            NodoAdyacencia actual = nodo.getAdyacencias();
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    private boolean existeAdyacencia( NodoGrafo nodo, String codigoVecino) {
        NodoAdyacencia actual = nodo.getAdyacencias();

        while (actual != null) {
            if (actual.getCodigoLibro().equals(codigoVecino)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void mostrarVecinos(String codigo) {
        NodoGrafo nodo = buscarNodo(codigo);
        if (nodo == null) {
            System.out.println("No existe un libro con el codigo: " + codigo);
            return;
        }
        NodoAdyacencia actual = nodo.getAdyacencias();
        if (actual == null) {
            System.out.println("El libro no tiene relaciones.");
            return;
        }

        System.out.println("Vecinos del libro "+ nodo.getLibro().getTitulo()+ ":");

        while (actual != null) {
            NodoGrafo vecino = buscarNodo(actual.getCodigoLibro());
            System.out.println("- " + vecino.getLibro().getCodigo() + " | " + vecino.getLibro().getTitulo());
            actual = actual.getSiguiente();
        }
    }

    public int calcularGrado(String codigo) {

        NodoGrafo nodo = buscarNodo(codigo);
        if (nodo == null) {
            return -1;
        }
        int grado = 0;
        NodoAdyacencia actual = nodo.getAdyacencias();

        while (actual != null) {
            grado++;
            actual = actual.getSiguiente();
        }
        return grado;
    }
}
