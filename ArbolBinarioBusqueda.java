public class ArbolBinarioBusqueda {

    private NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }
 
    // INSERTAR
    public void insertar(Libro libro) {

        if (raiz == null) {
            raiz = new NodoArbol(libro);
        } else {
            raiz = insertarRecursivo(raiz, libro);
        }
    }

    private NodoArbol insertarRecursivo( NodoArbol actual, Libro libro) {

        if (actual == null) {
            return new NodoArbol(libro);
        }

        int comparacion = libro.getCodigo().compareTo(actual.getLibro().getCodigo());

        if (comparacion < 0) {
            actual.setIzquierda(
                insertarRecursivo(actual.getIzquierda(),libro)
            );
        } else if (comparacion > 0) {
            actual.setDerecha(
                insertarRecursivo( actual.getDerecha(), libro)
            );
        } else {
            System.out.println("Ya existe un libro con el codigo: " + libro.getCodigo());
        }

        return actual;
    }

    // BUSCAR
    public Libro buscar(String codigo) {
        return buscarRecursivo(raiz, codigo);
    }

    private Libro buscarRecursivo(NodoArbol actual,String codigo) {

        if (actual == null) {
            return null;
        }

        int comparacion = codigo.compareTo( actual.getLibro().getCodigo());

        if (comparacion == 0) {
            return actual.getLibro();
        }

        if (comparacion < 0) {
            return buscarRecursivo(actual.getIzquierda(), codigo);
        }

        return buscarRecursivo(actual.getDerecha(),codigo);
    }
  
    // PREORDEN 

    public void preorden() {
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(NodoArbol actual) {

        if (actual == null) {
            return;
        }

        System.out.print( actual.getLibro().getCodigo() + " ");
        preordenRecursivo(actual.getIzquierda());
        preordenRecursivo(actual.getDerecha());
    }

    // INORDEN
    public void inorden() {
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(NodoArbol actual) {

        if (actual == null) {
            return;
        }

        inordenRecursivo(actual.getIzquierda());
        System.out.print( actual.getLibro().getCodigo() + " ");
        inordenRecursivo(actual.getDerecha());
    }

    // POSTORDEN

    public void postorden() {
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(NodoArbol actual) {
        if (actual == null) {
            return;
        }

        postordenRecursivo(actual.getIzquierda());
        postordenRecursivo(actual.getDerecha());
        System.out.print(actual.getLibro().getCodigo() + " ");
    }
 
    // ALTURA
    public int altura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(NodoArbol actual) {
        if (actual == null) {
            return -1;
        }

        int alturaIzquierda = calcularAltura(actual.getIzquierda());
        int alturaDerecha = calcularAltura(actual.getDerecha());
        return 1 + Math.max(alturaIzquierda,alturaDerecha);
    }
}
