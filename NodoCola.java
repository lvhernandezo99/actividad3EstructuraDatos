public class NodoCola {

    private Solicitud solicitud;
    private NodoCola siguiente;

    public NodoCola(Solicitud solicitud) {
        this.solicitud = solicitud;
        this.siguiente = null;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}
