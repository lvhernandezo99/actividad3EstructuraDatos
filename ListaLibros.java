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
    
        System.out.println("Libro insertado con éxito: " + libro.getTitulo());
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
            System.out.println("La lista está vacía.");
            return false;
        } 
      
        if (cabeza.getLibro().getCodigo().equals(codigo)) {
            cabeza = cabeza.getSiguiente();

            System.out.println("Libro con código " + codigo + " eliminado.");
            return true;
        }

        NodoLibro actual = cabeza;

        while (actual.getSiguiente() != null &&
               !actual.getSiguiente().getLibro().getCodigo().equals(codigo)) {

            actual = actual.getSiguiente();
        }
 
        if (actual.getSiguiente() != null) {

            actual.setSiguiente(actual.getSiguiente().getSiguiente());

            System.out.println("Libro con código " + codigo + " eliminado.");
            return true;
        }

        System.out.println("No se encontró ningún libro con el código: " + codigo);
        return false;
    }
 
    public void recorrer() {

        if (cabeza == null) {
            System.out.println("La lista de libros está vacía.");
            return;
        }

        NodoLibro actual = cabeza;

        System.out.println("--- LISTA DE LIBROS ---");

        while (actual != null) {

            Libro libro = actual.getLibro();

            System.out.println(
                "Código: " + libro.getCodigo() +
                " | Título: " + libro.getTitulo() +
                " | Autor: " + libro.getAutor() +
                " | Año: " + libro.getAnoPublicacion()
            );

            actual = actual.getSiguiente();
        }

        System.out.println("-----------------------");
    }
}
