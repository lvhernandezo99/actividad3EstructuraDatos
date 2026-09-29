public interface Cola {

    void encolar(Solicitud solicitud);

    Solicitud desencolar();

    Solicitud frente();

    boolean estaVacia();
}
