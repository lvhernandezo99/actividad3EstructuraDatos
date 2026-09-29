public class NodoAdyacencia {

    private String codigoLibro;
    private NodoAdyacencia siguiente;

    public NodoAdyacencia(String codigoLibro) {
        this.codigoLibro = codigoLibro;
        this.siguiente = null;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public NodoAdyacencia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAdyacencia siguiente) {
        this.siguiente = siguiente;
    }
}
