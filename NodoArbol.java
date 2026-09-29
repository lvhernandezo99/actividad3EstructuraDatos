public class NodoArbol {

    private Libro libro;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol(Libro libro) {
        this.libro = libro;
        this.izquierda = null;
        this.derecha = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
}
