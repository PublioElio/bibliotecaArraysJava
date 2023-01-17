<div id="header" align="center">
  <img src="https://media.giphy.com/media/N4h9A9o5TcWmjdQZVJ/giphy.gif" width="250"/>
</div>

# Biblioteca Arrays de Java
Este repositorio contiene funciones propias desarrolladas en Java para el manejo de _arrays_ de números enteros, imitando métodos existentes de la clase `Arrays` o `System`. La principal función del código del presente repositorio es entender mejor el funcionamiento de estos métodos y practicar algoritmia básica con _arrays_.

## Índice

La clase BibliotecaArrays contiene las siguientes funciones:

- [buscar](#buscar)
- [muestraArray](#muestraarray)
- [copiaDe](#copiade)
- [copiaDeRango](#copiaderango)
- [arrayCopia](#arraycopia)
- [insertarNoOrdenada](#insertarnoordenada)
- [insertarOrdenada](#insertarordenada)
- [eliminarNoOrdenada](#eliminarnoordenada)
- [eliminarOrdenada](#eliminarordenada)
- [iguales](#iguales)

## Explicación de las funciones

### buscar
Este método busca un elemento en un _array_ de enteros, devolviendo la posición donde lo ha encontrado, o un -1 si ese elemento no se encuentra en el _array_:
```
public static int buscar(int array[], int clave) {
    int pos = -1;
    for (int i = 0; (i < array.length) && (pos == -1); i++) {
        pos = array[i] == clave ? i : -1;
    }
    return (pos);
}
```
### muestraArray
Este método muestra por terminal un _array_ con sus elementos entre corchetes y separados por barras verticales.
```
public static void muestraArray(int[] array) {
    System.out.print("[");
    for (int i = 0; i < array.length; i++) {
        if (i == (array.length - 1)) {
            System.out.print(array[i]);
        } else {
            System.out.print(array[i] + " | ");
        }
    }
    System.out.println("]");
}
```
### copiaDe
Este método imita el comportamiento del método [copyOf](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#copyOf(int[],%20int)), copiando un array en otro de una determinada longitud. Si el nuevo _array_ el mayor que el anterior, llena los "huecos" con ceros, si la longitud del nuevo _array_ es inferior, copia hasta la longitud especificada:
```
public static int[] copiaDe(int[] origen, int longitud) {
    int[] destino = new int[longitud];
    for (int i = 0; (i < longitud) && (i < origen.length); i++) {
        destino[i] = origen[i];
    }
    return (destino);
}
```
### copiaDeRango
Este método imita el comportamiento del método [copyOfRange](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#copyOfRange(int[],%20int,%20int)), copiando un rango de elementos dentro de un _array_ y devolviéndolo en un nuevo _array_:
```
public static int[] copiaDeRango(int[] origen, int desde, int hasta) {
    int[] destino = new int[hasta - desde];
    for (int i = 0; i < destino.length; i++) {
        destino[i] = origen[desde + i];
    }
    return (destino);
}
```
### arrayCopia
Este método imita el comportamiento del método [arrayCopy](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#arraycopy(java.lang.Object,%20int,%20java.lang.Object,%20int,%20int)), copiando un fragmento de un _array_ en otro, eliminando de esta forma, el contenido previo de esos elementos del _array_ destino:
```
public static void arrayCopia(int[] origen, int posicionOrigen, int[] destino, int posicionDestino, int longitud) {
    for (int i = 0; i < longitud; i++) {
        destino[posicionDestino + i] = origen[posicionOrigen + i];
    }
}
```
### insertarNoOrdenada
Este método inserta un elemento al final de un _array_ cuyos elementos están desordenados:
```
public static int[] insertarNoOrdenada(int[] origen, int elemento) {
    origen = copiaDe(origen, origen.length + 1);
    origen[origen.length - 1] = elemento;
    return (origen);
}
```
### insertarOrdenada
Este método inserta un nuevo elemento en un _array_ ordenado. El código hace uso del método [Arrays.binarySearch](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch(int[],%20int)), así que hay que importar la clase `Arrays` para usar este método.
```
public static int[] insertarOrdenada(int[] array, int nuevo) {
        int indiceInsercion = Arrays.binarySearch(array, nuevo);
        if (indiceInsercion < 0) {
            indiceInsercion = -indiceInsercion - 1;
        }
        int copia[] = new int[array.length + 1];
        arrayCopia(array, 0, copia, 0, indiceInsercion);
        arrayCopia(array, indiceInsercion, copia, (indiceInsercion + 1), (array.length - indiceInsercion));
        copia[indiceInsercion] = nuevo;
        return (copia);
}
```
### eliminarNoOrdenada
Este método elimina un elemento dentro de un _array_ desordenado (si lo encuentra):
```
public static int[] eliminarNoOrdenada(int[] array, int clave) {
    int indiceBorrado;
    indiceBorrado = buscar(array, clave);
    if (indiceBorrado != -1) {
        array[indiceBorrado] = array[array.length - 1];
        array = copiaDe(array, array.length - 1);
    }
    return (array);
}
```
### eliminarOrdenada
Este método elimina un elemento de un _array_ ordenado de enteros, al igual que el método `insertarOrdenada` de esta biblioteca, tendremos que immportar la clase [Arrays.binarySearch](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch(int[],%20int)).
```
public static int[] eliminarOrdenada(int[] origen, int elemento) {
    int indiceBorrado;
    indiceBorrado = Arrays.binarySearch(origen, elemento);
    if (indiceBorrado >= 0) {
        for (int i = indiceBorrado; i < origen.length - 1; i++) {
            origen[i] = origen[i + 1];
        }
        origen = copiaDe(origen, origen.length - 1);
    }
    return (origen);
}
```
### iguales 
Este método compara dos _arrays_ y devuelve _'true'_ si contiene el mismo número de elementos en el mismo orden, es decir, si ambos _arrays_ son idénticos. Es una imitación del método [Arrays.equals](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#equals(int[],%20int[])):
```
public static boolean iguales(int[] a, int[] b) {
    boolean sonIguales = false;

    if (a.length == b.length) {
        sonIguales = true;
        for (int i = 0; i < a.length && sonIguales; i++) {
            sonIguales = a[i] == b[i];
        }
    }
    return (sonIguales);
}
```
## Implementación en el código
Para emplear esta biblioteca, hay que incluir el archivo `BibliotecaArrays.java` en tu proyecto e importarlo en aquellas clases donde se llame a cualquiera de sus métodos, con la siguiente línea de código justo antes del `main`:
```
import static biblioteca.arrays.BibliotecaArrays.*;
```
## Testeo
Los métodos de la presente biblioteca se han testeado con la clase `TestBibliotecaArrays.java`

