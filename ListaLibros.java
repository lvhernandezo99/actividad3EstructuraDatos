public class ListaLibros {

    private NodoLibro cabeza;

    public ListaLibros() {
        this.cabeza = null;
    }
 
    public void insertar(Libro libro) {
  
        if (buscar(libro.getCodigo()) != null) {
            System.out.println("Ya existe un libro con el código: " + libro.getCodigo());
            return;
        }
    
        NodoLibro nuevoNodo = new NodoLibro(libro);
    
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLibro actual = cabeza;
    
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
    
            actual.setSiguiente(nuevoNodo);
        }
    
        System.out.println("Libro insertado con exito: " + libro.getTitulo());
    }
   
    public Libro buscar(String codigo) {
        NodoLibro actual = cabeza;

        while (actual != null) {
            if (actual.getLibro().getCodigo().equals(codigo)) {
                return actual.getLibro();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean eliminar(String codigo) {

        if (cabeza == null) {
            System.out.println("La lista esta vacía.");
            return false;
        } 
      
        if (cabeza.getLibro().getCodigo().equals(codigo)) {
            cabeza = cabeza.getSiguiente();

            System.out.println("Libro con codigo " + codigo + " eliminado.");
            return true;
        }

        NodoLibro actual = cabeza;

        while (actual.getSiguiente() != null &&
               !actual.getSiguiente().getLibro().getCodigo().equals(codigo)) {

            actual = actual.getSiguiente();
        }
 
        if (actual.getSiguiente() != null) {

            actual.setSiguiente(actual.getSiguiente().getSiguiente());

            System.out.println("Libro con codigo " + codigo + " eliminado.");
            return true;
        }

        System.out.println("No se encontro ningun libro con el codigo: " + codigo);
        return false;
    }
 
    public void recorrer() {

        if (cabeza == null) {
            System.out.println("La lista de libros esta vacia.");
            return;
        }

        NodoLibro actual = cabeza;

        System.out.println("--- LISTA DE LIBROS ---");

        while (actual != null) {

            Libro libro = actual.getLibro();

            System.out.println(
                "Codigo: " + libro.getCodigo() +
                " | Titulo: " + libro.getTitulo() +
                " | Autor: " + libro.getAutor() +
                " | Año: " + libro.getAnoPublicacion()
            );

            actual = actual.getSiguiente();
        }

        System.out.println("-----------------------");
    }
}
