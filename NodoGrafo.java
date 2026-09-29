public class NodoGrafo {

    private Libro libro;
    private NodoAdyacencia adyacencias;
    private NodoGrafo siguiente;

    public NodoGrafo(Libro libro) {
        this.libro = libro;
        this.adyacencias = null;
        this.siguiente = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public NodoAdyacencia getAdyacencias() {
        return adyacencias;
    }

    public void setAdyacencias(NodoAdyacencia adyacencias) {
        this.adyacencias = adyacencias;
    }

    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }
}
