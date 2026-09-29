public class ColaEnlazada implements Cola {

    private NodoCola frente;
    private NodoCola finalCola;

    public ColaEnlazada() {
        this.frente = null;
        this.finalCola = null;
    }

    @Override
    public boolean estaVacia() {
        return frente == null;
    }

    @Override
    public void encolar(Solicitud solicitud) {

        NodoCola nuevoNodo = new NodoCola(solicitud);

        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
    }

    @Override
    public Solicitud desencolar() {

        if (estaVacia()) {
            return null;
        }

        Solicitud solicitud = frente.getSolicitud();

        frente = frente.getSiguiente();

        if (frente == null) {
            finalCola = null;
        }

        return solicitud;
    }

    @Override
    public Solicitud frente() {

        if (estaVacia()) {
            return null;
        }

        return frente.getSolicitud();
    }
}
