# Sistema de gestión de biblioteca

## 1. Descripción del proyecto

Este proyecto consiste en un sistema básico de gestión de biblioteca. Su objetivo es organizar la información de los libros, facilitar su búsqueda, gestionar las solicitudes de préstamo y representar las relaciones entre diferentes libros.

El sistema utiliza distintas estructuras de datos para resolver cada necesidad. Por ejemplo, los libros se almacenan en una lista enlazada, las búsquedas por código se realizan mediante un árbol binario de búsqueda y las solicitudes de préstamo se atienden utilizando una cola.

Para este proyecto, los libros y los usuarios se encuentran precargados en el código. No se implementó una interfaz de usuario ni el ingreso de datos por teclado, ya que el enfoque principal es demostrar el funcionamiento de las estructuras de datos.

## 2. Modelo del sistema

### Clases principales

* **Libro:** contiene el código, título, autor, categoría, año de publicación y editorial.
* **Usuario:** almacena los datos básicos de una persona que realiza solicitudes de préstamo.
* **Solicitud:** relaciona un usuario con el código del libro que desea solicitar.
* **ListaLibros:** administra los libros mediante una lista simplemente enlazada.
* **ArbolBinarioBusqueda:** organiza los libros según su código y permite realizar búsquedas y recorridos.
* **Cola:** define el contrato común para las implementaciones de la cola.
* **ColaEnlazada:** implementa una cola utilizando nodos enlazados.
* **ColaArreglo:** implementa una cola circular mediante un arreglo de capacidad fija.
* **Grafo:** representa las relaciones entre libros mediante listas de adyacencia.

### Relación entre las clases
                       Libro
                         |
          +--------------+---------------+
          |              |               |
      NodoLibro      NodoArbol        NodoGrafo
          |              |               |
     ListaLibros    ArbolBinario       Grafo
                    de Búsqueda
                                         |
                                  NodoAdyacencia

       Usuario
          |
      Solicitud
          |
        Cola
          |
    +-----+------+
    |            |
ColaEnlazada  ColaArreglo


La clase '**Cola**' funciona como una interfaz común para las dos implementaciones. Esto permite cambiar la estructura utilizada sin modificar la lógica que realiza las operaciones de la cola.

## 3. Estructuras de datos utilizadas

### 3.1. Lista simplemente enlazada

Se utiliza para almacenar y recorrer los libros de la biblioteca.

Cada nodo contiene un objeto '**Libro**' y una referencia al siguiente nodo. Se eligió una lista simplemente enlazada porque el sistema necesita recorrer los libros en una sola dirección y no requiere desplazamientos hacia atrás.

Operaciones implementadas:

* Insertar un libro al final.
* Buscar un libro por su código.
* Eliminar un libro.
* Recorrer y mostrar todos los libros.
* Evitar códigos duplicados.

La lista contempla situaciones como estar vacía, eliminar su único elemento e intentar buscar o eliminar un código inexistente.

### 3.2. Árbol binario de búsqueda (BST)

El árbol permite organizar los libros por su código para facilitar las búsquedas.

En cada nodo, los códigos menores se ubican en el subárbol izquierdo y los códigos mayores en el derecho. Los códigos duplicados no se insertan.

Se implementaron las siguientes operaciones:

* Insertar libros.
* Buscar por código.
* Recorrido preorden.
* Recorrido inorden.
* Recorrido postorden.
* Calcular la altura del árbol mediante recursividad.

El recorrido inorden permite mostrar los códigos de los libros en orden ascendente.

La altura se mide en aristas. Por esta razón, un árbol vacío tiene altura -1 y un nodo hoja tiene altura 0.

### 3.3. Cola de solicitudes

La cola permite atender las solicitudes de préstamo según el orden en el que fueron registradas, siguiendo el principio FIFO 

Se implementaron dos versiones con el mismo contrato:

* **Cola enlazada:** utiliza nodos y referencias al frente y al final de la cola.
* **Cola basada en arreglo:** utiliza un arreglo circular de capacidad fija.

Las operaciones disponibles son:

* **encolar()**: agrega una solicitud al final.
* **desencolar()**: retira y devuelve la solicitud que está al frente.
* **frente():** consulta la primera solicitud sin retirarla.
* **estaVacia()**: comprueba si la cola está vacía.

Para cambiar la implementación utilizada en el programa, solo es necesario modificar la instancia:

====================
Cola cola = new ColaEnlazada();
// Cola cola = new ColaArreglo(10);
====================

Al utilizar la versión basada en arreglo, se debe tener en cuenta su capacidad fija.

### 3.4. Grafo de relaciones

El grafo representa relaciones entre libros que no dependen de una jerarquía. Por ejemplo, dos libros pueden estar relacionados porque pertenecen a una misma temática, saga o área de conocimiento.

Se utilizó un grafo no dirigido con listas de adyacencia. Esto significa que, si se establece una relación entre dos libros, ambos aparecen como vecinos entre sí.

Operaciones implementadas:

* Agregar libros al grafo.
* Crear relaciones entre libros.
* Consultar los vecinos de un libro.
* Calcular el grado de un vértice.

El grado representa la cantidad de relaciones directas que tiene un libro con otros libros.

## 4. Justificación de las estructuras

Se eligieron las estructuras de acuerdo con las necesidades del sistema:

* **Lista enlazada:** permite administrar los libros de forma dinámica sin establecer una capacidad fija.
* **Árbol binario de búsqueda:** permite organizar los libros por código y realizar búsquedas aprovechando la comparación entre valores.
* **Cola:** representa de manera natural la atención ordenada de solicitudes.
* **Grafo:** permite representar relaciones múltiples entre libros sin imponer una estructura jerárquica.

Cada estructura cumple una función específica y permite demostrar diferentes formas de organizar y procesar información.

## 5. Comparación entre la cola enlazada y la cola basada en arreglo

Ambas implementaciones cumplen el mismo contrato y siguen el comportamiento FIFO, pero tienen diferencias en el manejo de memoria.

| Característica          | Cola enlazada                                | Cola basada en arreglo          |
| ----------------------- | -------------------------------------------- | ------------------------------- |
| Almacenamiento          | Nodos enlazados                              | Arreglo circular                |
| Capacidad               | Dinámica, limitada por la memoria disponible | Fija al crear la cola           |
| Encolar                 | O(1)                                         | O(1)                            |
| Desencolar              | O(1)                                         | O(1)                            |
| Consultar el frente     | O(1)                                         | O(1)                            |
| Comprobar si está vacía | O(1)                                         | O(1)                            |
| Memoria adicional       | Referencias y objetos nodo                   | Espacio reservado en el arreglo |

La cola enlazada permite agregar elementos sin definir previamente una capacidad. Por otro lado, la cola basada en arreglo reserva su espacio desde el inicio y utiliza posiciones de manera circular para reutilizar las posiciones liberadas.

## 6. Experimento de altura del árbol binario de búsqueda

Se realizó un experimento para observar cómo influye el orden de inserción en la altura de un árbol binario de búsqueda.

Se utilizaron los mismos códigos de libros en dos secuencias diferentes:

* **Inserción desordenada:** los códigos se insertaron en un orden mezclado.
* **Inserción ordenada:** los códigos se insertaron de menor a mayor.

Se realizaron pruebas con 5, 10 y 15 nodos.

### Resultados

| Número de nodos | Altura desordenada | Altura ordenada |
| --------------: | -----------------: | --------------: |
|               5 |                  2 |               4 |
|              10 |                  4 |               9 |
|              15 |                  4 |              14 |

### Análisis

En las pruebas con inserción ordenada, la altura aumentó de manera lineal. Esto sucede porque cada nuevo código se ubica como hijo derecho del anterior, formando un árbol completamente inclinado hacia un lado.

En cambio, los resultados de la inserción desordenada muestran una distribución más equilibrada de los nodos. En las pruebas realizadas, la altura fue menor y se mantuvo en 4 al pasar de 10 a 15 nodos.

La altura influye en la cantidad de niveles que se pueden recorrer durante una búsqueda. Por lo tanto, un árbol de menor altura suele permitir encontrar un elemento con menos comparaciones.

Este experimento permite observar que un árbol binario de búsqueda tradicional no garantiza por sí solo un buen equilibrio. Su rendimiento depende, entre otros factores, del orden en el que se insertan los elementos.

## 7. Ejercicio manual de árbol AVL

Como parte de la actividad, se realizó un ejercicio manual de balanceo de un árbol AVL utilizando códigos de libros insertados en orden ascendente.

Un árbol AVL es un árbol binario de búsqueda que mantiene su equilibrio mediante rotaciones. Después de cada inserción, se revisan los factores de equilibrio de los nodos para identificar posibles desequilibrios.

En el ejercicio se identificaron los casos de desequilibrio y las rotaciones necesarias para recuperar el balance del árbol.

## 8. Pruebas realizadas

Se ejecutaron pruebas para comprobar el funcionamiento de las estructuras y verificar el comportamiento en situaciones normales y casos especiales.

| Estructura     | Prueba                                   | Resultado  |
| -------------- | ---------------------------------------- | ---------- |
| Lista enlazada | Insertar y recorrer libros               | Correcto   |
| Lista enlazada | Buscar un código existente               | Correcto   |
| Lista enlazada | Buscar un código inexistente             | Controlado |
| Lista enlazada | Insertar un código duplicado             | Rechazado  |
| Lista enlazada | Eliminar un libro existente              | Correcto   |
| Lista enlazada | Eliminar un código inexistente           | Controlado |
| Lista enlazada | Eliminar el único elemento               | Correcto   |
| BST            | Recorridos preorden, inorden y postorden | Correcto   |
| BST            | Buscar un código existente               | Correcto   |
| BST            | Buscar un código inexistente             | Controlado |
| BST            | Calcular la altura                       | Correcto   |
| Cola           | Atender solicitudes en orden FIFO        | Correcto   |
| Cola           | Comprobar si está vacía                  | Correcto   |
| Grafo          | Consultar vecinos                        | Correcto   |
| Grafo          | Calcular el grado                        | Correcto   |
| Grafo          | Crear una relación duplicada             | Rechazada  |
| Grafo          | Consultar un libro inexistente           | Controlado |

También se comprobó el comportamiento de las dos implementaciones de la cola mediante el cambio de la instancia utilizada en el programa.

## 9. Instrucciones de ejecución

### Requisitos

* Java JDK instalado.
* Un entorno de desarrollo compatible con Java, como IntelliJ IDEA, Eclipse o Visual Studio Code con las extensiones correspondientes.

## 10. Limitaciones y posibles mejoras

El sistema cumple el objetivo académico de implementar y probar distintas estructuras de datos, pero presenta algunas limitaciones:

* Los libros y usuarios están precargados en el código, por lo que no se pueden registrar desde una interfaz.
* La información no se guarda en una base de datos ni en archivos, así que se pierde al finalizar la ejecución.
* El árbol binario de búsqueda no se balancea automáticamente y puede degradar su rendimiento si los códigos se insertan en orden.
* La cola basada en arreglo tiene una capacidad fija.
* El grafo utiliza relaciones definidas manualmente y no incorpora un algoritmo automático de recomendaciones.
* No se implementó un proceso completo de préstamo y devolución que actualice la disponibilidad de los libros.

Como mejoras futuras, se podría incorporar persistencia de datos, una interfaz para registrar libros y usuarios, un árbol AVL para mantener el equilibrio, validaciones adicionales y un módulo completo de préstamos y devoluciones.

