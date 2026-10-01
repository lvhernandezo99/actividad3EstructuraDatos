public class Main {
    public static void main(String[] args) {
        // 1. CREAR LIBROS
        Libro libro1 = new Libro("2811", "Clean Code", "Robert C. Martin", "Programación", 2008, "Prentice Hall");
        Libro libro2 = new Libro("8703", "The Pragmatic Programmer", "Andrew Hunt", "Programación", 1999, "Addison-Wesley");
        Libro libro3 = new Libro("1205", "Refactoring", "Martin Fowler", "Programación", 1999,"Addison-Wesley");
        Libro libro4 = new Libro("1224","Design Patterns","Erich Gamma","Programación",1994,"Addison-Wesley");
        Libro libro5 = new Libro("1904","Effective Java", "Joshua Bloch","Programación", 2018,"Addison-Wesley");
 
        // 2. LISTA ENLAZADA DE LIBROS 
        System.out.println("==/////////////////////////////////==");
        System.out.println("LISTA ENLAZADA");
        System.out.println("==/////////////////////////////////==");

        ListaLibros listaLibros = new ListaLibros();
        listaLibros.insertar(libro1);
        listaLibros.insertar(libro2);
        listaLibros.insertar(libro3);
        listaLibros.insertar(libro4);
        listaLibros.insertar(libro5);
        listaLibros.recorrer();

        System.out.println("\nBuscando libro 1205:");

        Libro encontrado = listaLibros.buscar("1205");

        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
 
        // 3. ÁRBOL BINARIO DE BÚSQUEDA 
        System.out.println("\n==/////////////////////////////////==");
        System.out.println("ÁRBOL BINARIO DE BÚSQUEDA");
        System.out.println("==/////////////////////////////////==");

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        arbol.insertar(libro1);
        arbol.insertar(libro2);
        arbol.insertar(libro3);
        arbol.insertar(libro4);
        arbol.insertar(libro5);

        System.out.println("Preorden:");
        arbol.preorden();

        System.out.println("Inorden:");
        arbol.inorden();

        System.out.println("Postorden:");
        arbol.postorden();

        System.out.println("Altura del árbol: " + arbol.altura());

        System.out.println("\nBuscando libro 1904:");

        Libro encontradoArbol = arbol.buscar("1904");

        if (encontradoArbol != null) {
            System.out.println( "Encontrado: " + encontradoArbol.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
 
        // 4. COLA DE SOLICITUDES 

        System.out.println("\n==/////////////////////////////////==");
        System.out.println("COLA DE SOLICITUDES");
        System.out.println("==/////////////////////////////////==");

        Usuario usuario1 = new Usuario( "Laura","1001","3001111111","Medellin","laura@gmail.com");
        Usuario usuario2 = new Usuario( "Sofia","1002","3002222222","Medellin","sofia@gmail.com");
        Usuario usuario3 = new Usuario( "Daniela","1003","3003333333","Medellin","daniela@gmail.com");

        Solicitud solicitud1 = new Solicitud(usuario1, "101");
        Solicitud solicitud2 = new Solicitud(usuario2, "205");
        Solicitud solicitud3 = new Solicitud(usuario3, "310");


        // las dos implementaciones de la cola.
        Cola cola = new ColaEnlazada();
        //Cola cola = new ColaArreglo(10);

        cola.encolar(solicitud1);
        cola.encolar(solicitud2);
        cola.encolar(solicitud3);

        System.out.println( "Primera solicitud: "+ cola.frente().getUsuario().getNombre());
        System.out.println( "Atendiendo: "+ cola.desencolar().getUsuario().getNombre());
        System.out.println( "Siguiente solicitud: "+ cola.frente().getUsuario().getNombre());

 
        // 5. GRAFO DE RELACIONES 

        System.out.println("\n==/////////////////////////////////==");
        System.out.println("GRAFO DE RELACIONES");
        System.out.println("==/////////////////////////////////==");

        Grafo grafo = new Grafo();

        grafo.agregarLibro(libro1);
        grafo.agregarLibro(libro2);
        grafo.agregarLibro(libro3);
        grafo.agregarLibro(libro4);
        grafo.agregarLibro(libro5);

        // Relaciones entre libros
        grafo.agregarRelacion("2811", "8703");
        grafo.agregarRelacion("2811", "1205");
        grafo.agregarRelacion("8703", "1224");
        grafo.agregarRelacion("1205", "1224");
        grafo.agregarRelacion("1224", "1904");

        System.out.println("\nVecinos del libro 2811:");
        grafo.mostrarVecinos("2811");
        System.out.println("\nGrado del libro 2811: "+ grafo.calcularGrado("2811"));
        System.out.println("Grado del libro 1224: "+ grafo.calcularGrado("1224"));


        // 6. CASOS LIMITE

        System.out.println("\n==/////////////////////////////////==");
        System.out.println("CASOS LIMITE");
        System.out.println("==/////////////////////////////////==");

        // Libro duplicado
        System.out.println("\nIntentando insertar libro duplicado:");
        listaLibros.insertar(libro1);

        // Buscar libro inexistente
        System.out.println("\nBuscando libro inexistente:");

        Libro inexistente = listaLibros.buscar("1805");

        if (inexistente == null) {
            System.out.println("No se encontró el libro 1805.");
        }

        // Eliminar libro inexistente
        System.out.println("\nEliminando libro inexistente:");

        listaLibros.eliminar("1805");

        // Relación duplicada
        System.out.println("\nIntentando crear relación duplicada:");

        grafo.agregarRelacion("2811", "8703");

        // Libro inexistente en el grafo
        System.out.println("\nBuscando vecinos de libro inexistente:");

        grafo.mostrarVecinos("1805");
    }
}
