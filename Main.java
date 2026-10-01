public class Main {
    public static void main(String[] args) {
        // 1. CREAR LIBROS
       
        Libro libro1 = new Libro("2811","Clean Code","Robert C. Martin","Programación",2008,"Prentice Hall");
        Libro libro2 = new Libro("8703","The Pragmatic Programmer","Andrew Hunt","Programación",1999,"Addison-Wesley");
        Libro libro3 = new Libro("1205","Refactoring","Martin Fowler","Programación",1999,"Addison-Wesley");
        Libro libro4 = new Libro("1224","Design Patterns","Erich Gamma","Programación",1994,"Addison-Wesley");
        Libro libro5 = new Libro("1904","Effective Java","Joshua Bloch","Programación",2018,"Addison-Wesley");
        Libro libro6 = new Libro("6438","Don't Make Me Think","Steve Krug","Diseño Web",2014,"New Riders");
        Libro libro7 = new Libro("3517","Code Complete","Steve McConnell","Programación",2004,"Microsoft Press");
        Libro libro8 = new Libro("9264","Head First Java","Kathy Sierra","Programación",2005,"O'Reilly Media");
        Libro libro9 = new Libro("4172","The Mythical Man-Month","Frederick Brooks","Ingeniería de Software",1995,"Addison-Wesley");
        Libro libro10 = new Libro("7385","Introduction to Algorithms","Thomas H. Cormen","Algoritmos",2009,"MIT Press");
        Libro libro11 = new Libro("2649","You Don't Know JS","Kyle Simpson","JavaScript",2015,"O'Reilly Media");
        Libro libro12 = new Libro("5813","Eloquent JavaScript","Marijn Haverbeke","JavaScript",2018,"No Starch Press");
        Libro libro13 = new Libro("8046","Clean Architecture","Robert C. Martin","Arquitectura",2017,"Prentice Hall");
        Libro libro14 = new Libro("3295","Domain-Driven Design","Eric Evans","Arquitectura",2003,"Addison-Wesley");
        Libro libro15 = new Libro("1578","The Clean Coder","Robert C. Martin","Programación",2011,"Prentice Hall");
 
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
        listaLibros.insertar(libro6);
        listaLibros.insertar(libro7);
        listaLibros.insertar(libro8);
        listaLibros.insertar(libro9);
        listaLibros.insertar(libro10);
        listaLibros.insertar(libro11);
        listaLibros.insertar(libro12);
        listaLibros.insertar(libro13);
        listaLibros.insertar(libro14);
        listaLibros.insertar(libro15);
        listaLibros.recorrer();

        System.out.println("\nBuscando libro 2811:");

        Libro encontrado = listaLibros.buscar("2811");

        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }

        System.out.println("\n--- Buscar clave inexistente ---");

        Libro noEncontrado = listaLibros.buscar("9999");

        if (noEncontrado == null) {
            System.out.println("No se encontro el libro.");
        }

        System.out.println("\n--- Insertar clave repetida ---");

        listaLibros.insertar(libro1);

        System.out.println("\n--- Eliminar libro ---");

        listaLibros.eliminar("2811");

        listaLibros.recorrer();

        System.out.println("\n--- Eliminar clave inexistente ---");

        listaLibros.eliminar("9999");

        System.out.println("\n--- Eliminar unico elemento ---");

        ListaLibros listaTemporal = new ListaLibros();

        listaTemporal.insertar(libro1);

        listaTemporal.eliminar("2811");

        listaTemporal.recorrer();
        
 
        // 3. ÁRBOL BINARIO DE BÚSQUEDA 
        System.out.println("\n==/////////////////////////////////==");
        System.out.println("ARBOL BINARIO DE BUSQUEDA");
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

        System.out.println("Altura del arbol: " + arbol.altura());

        System.out.println("\nBuscando libro 1904:");

        Libro encontradoArbol = arbol.buscar("1904");

        if (encontradoArbol != null) {
            System.out.println( "Encontrado: " + encontradoArbol.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }

        System.out.println("\nBuscando codigo inexistente en el arbol:");

        Libro noEncontradoArbol = arbol.buscar("9999");

        if (noEncontradoArbol == null) {
            System.out.println("No se encontro el libro 9999.");
        }
        
        // 4. COLA DE SOLICITUDES 

        System.out.println("\n==/////////////////////////////////==");
        System.out.println("COLA DE SOLICITUDES");
        System.out.println("==/////////////////////////////////==");

        Usuario usuario1 = new Usuario( "Laura","1001","3001111111","Medellin","laura@gmail.com");
        Usuario usuario2 = new Usuario( "Sofia","1002","3002222222","Medellin","sofia@gmail.com");
        Usuario usuario3 = new Usuario( "Daniela","1003","3003333333","Medellin","daniela@gmail.com");

        Solicitud solicitud1 = new Solicitud(usuario1, "2811");
        Solicitud solicitud2 = new Solicitud(usuario2, "8703");
        Solicitud solicitud3 = new Solicitud(usuario3, "1205");


        // las dos implementaciones de la cola.
        Cola cola = new ColaEnlazada();
        //Cola cola = new ColaArreglo(10);

        cola.encolar(solicitud1);
        cola.encolar(solicitud2);
        cola.encolar(solicitud3);

        System.out.println( "Primera solicitud: "+ cola.frente().getUsuario().getNombre());
        System.out.println( "Atendiendo: "+ cola.desencolar().getUsuario().getNombre());
        System.out.println( "Siguiente solicitud: "+ cola.frente().getUsuario().getNombre());

        // Atendemos las solicitudes restantes
        cola.desencolar();
        cola.desencolar();
        
        if (cola.estaVacia()) {
            System.out.println("La cola está vacía.");
        }

        // ntenta desencolar cuando esta vacia
        Solicitud solicitudVacia = cola.desencolar();

        if (solicitudVacia == null) {
            System.out.println("No hay solicitudes para atender.");
        }
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

        // Relación duplicada
        System.out.println("\nIntentando crear relacion duplicada:");
        grafo.agregarRelacion("2811", "8703");

        // Libro inexistente en el grafo
        System.out.println("\nBuscando vecinos de libro inexistente:");
        grafo.mostrarVecinos("9999");


        // 6. EXPERIMENTO DE ALTURA DEL BST

        // n = 5
        System.out.println("\n==/////////////////////////////////==");
        System.out.println("EXPERIMENTO DE ALTURA DEL BST");
        System.out.println("==/////////////////////////////////==");
        
        Libro[] datos5Desordenados = {libro15,libro3,libro5,libro11,libro4};        
        Libro[] datos5Ordenados = {libro3,libro4,libro15,libro5,libro11};        
        int altura5Desordenados = calcularAltura(datos5Desordenados);
        int altura5Ordenados = calcularAltura(datos5Ordenados);
        
        System.out.println("n = 5");
        System.out.println("Altura desordenado: " + altura5Desordenados);
        System.out.println("Altura ordenado: " + altura5Ordenados);

        // n = 10
        Libro[] datos10Desordenados = {libro12,libro1,libro15,libro3,libro9,libro14,libro5,libro11,libro7,libro4};
        Libro[] datos10Ordenados = {libro3,libro4,libro15,libro5,libro11,libro1,libro14,libro7,libro9,libro12};
        int altura10Desordenados = calcularAltura(datos10Desordenados);
        int altura10Ordenados = calcularAltura(datos10Ordenados);

        System.out.println("\n n = 10");
        System.out.println("Altura desordenado: " + altura10Desordenados);
        System.out.println("Altura ordenado: " + altura10Ordenados);

        // n = 15
        Libro[] datos15Desordenados = {libro12,libro1,libro2,libro15,libro6,libro3,libro9,libro8,libro14,libro10,libro5,libro13,libro11,libro7,libro4};
        Libro[] datos15Ordenados = {libro3,libro4,libro15,libro5,libro11,libro1,libro14,libro7,libro9,libro12,libro6,libro10,libro13,libro2,libro8};

        int altura15Desordenados = calcularAltura(datos15Desordenados);
        int altura15Ordenados = calcularAltura(datos15Ordenados);
        System.out.println("\n n = 15");
        System.out.println("Altura desordenado: " + altura15Desordenados);
        System.out.println("Altura ordenado: " + altura15Ordenados);
    }

    private static int calcularAltura(Libro[] libros) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();    
        for (Libro libro : libros) {
            arbol.insertar(libro);
        }    
        return arbol.altura();
    }
}
