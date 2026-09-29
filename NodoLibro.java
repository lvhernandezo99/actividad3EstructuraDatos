public class NodoLibro {
    private Libro libro;
    private NodoLibro siguiente;

    public NodoLibro(Libro libro) {
        this.libro = libro;
        this.siguiente = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public NodoLibro getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLibro siguiente) {
        this.siguiente = siguiente;
    }
}
