public class ColaArreglo implements Cola {

    private Solicitud[] elementos;
    private int frente;
    private int finalCola;
    private int cantidad;

    public ColaArreglo(int capacidad) {
        elementos = new Solicitud[capacidad];
        frente = 0;
        finalCola = 0;
        cantidad = 0;
    }

    @Override
    public boolean estaVacia() {
        return cantidad == 0;
    }

    @Override
    public void encolar(Solicitud solicitud) {

        if (cantidad == elementos.length) {
            System.out.println("La cola esta llena.");
            return;
        }

        elementos[finalCola] = solicitud;
        finalCola = (finalCola + 1) % elementos.length;
        cantidad++;
    }

    @Override
    public Solicitud desencolar() {

        if (estaVacia()) {
            return null;
        }

        Solicitud solicitud = elementos[frente];

        elementos[frente] = null;
        frente = (frente + 1) % elementos.length;
        cantidad--;

        return solicitud;
    }

    @Override
    public Solicitud frente() {

        if (estaVacia()) {
            return null;
        }

        return elementos[frente];
    }
}
