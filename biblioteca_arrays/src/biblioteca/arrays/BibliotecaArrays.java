package biblioteca.arrays;

import java.util.Arrays;

/**
 * Esta es una biblioteca de funciones relacionadas con manejo de arrays,
 * imitando métodos ya existentes de la clase 'Arrays'
 *
 * @author Adriano Díaz Benítez <Adriano.Díaz>
 */
public class BibliotecaArrays {

    /**
     * Este método busca un elemento en un array de enteros, devolviendo la
     * posición donde lo ha encontrado, o un -1 si ese elemento no se encuentra
     * en el array
     *
     * @param array el array donde buscar el elemento
     * @param clave la clave a buscar
     * @return la posición donde se encuentra el elemento o un -1 si no está en
     * el array
     */
    public static int buscar(int array[], int clave) {
        int pos = -1;
        for (int i = 0; (i < array.length) && (pos == -1); i++) {
            pos = array[i] == clave ? i : -1;
        }
        return (pos);
    }

    /**
     * Este método muestra por terminal un array con sus elementos entre
     * corchetes y separados por guiones
     *
     * @param array el array a mostrar
     */
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

    /**
     * Este método imita el comportamiento del método copyOf, copiando un array
     * en otro de una determinada longitud. Si el nuevo array el mayor que el
     * anterior, llena los "huecos" con ceros, si la longitud del nuevo array es
     * inferior, copia hasta la longitud especificada
     *
     * @param origen array que vamos a copiar
     * @param longitud la longitud del array destino
     * @return el array copiado
     */
    public static int[] copiaDe(int[] origen, int longitud) {
        int[] destino = new int[longitud];
        for (int i = 0; (i < longitud) && (i < origen.length); i++) {
            destino[i] = origen[i];
        }
        return (destino);
    }

    /**
     * Este método imita el comportamiento del método copyOfRange, copiando un
     * rango de elementos dentro de un array y devolviéndolo en un nuevo array
     *
     * @param origen el array que vamos a copiar
     * @param desde desde dónde vamos a copiar (incluido)
     * @param hasta hasta dónde vamos a copiar (no incluido)
     * @return el nuevo array con el rango determinado
     */
    public static int[] copiaDeRango(int[] origen, int desde, int hasta) {
        int[] destino = new int[hasta - desde];
        for (int i = 0; i < destino.length; i++) {
            destino[i] = origen[desde + i];
        }
        return (destino);
    }

    /**
     * Este método imita el comportamiento del método arrayCopy, copiando un
     * fragmento de un array de enteros en otro, eliminando de esta forma, el
     * contenido previo de esos elementos del array destino
     *
     * @param origen el array del que vamos a copiar un fragmento
     * @param posicionOrigen la posición desde donde empezaremos a copiar
     * @param destino el array donde vamos a copiar
     * @param posicionDestino la posición desde donde vamos a copiar
     * @param longitud la cantidad de posiciones que vamos a copiar
     */
    public static void arrayCopia(int[] origen, int posicionOrigen,
            int[] destino, int posicionDestino, int longitud) {
        for (int i = 0; i < longitud; i++) {
            destino[posicionDestino + i] = origen[posicionOrigen + i];
        }
    }

    /**
     * Este método inserta un elemento al final de un array desordenado
     *
     * @param origen el array a modificar
     * @param elemento el elemento a insertar
     * @return el array modificado
     */
    public static int[] insertarNoOrdenada(int[] origen, int elemento) {
        origen = copiaDe(origen, origen.length + 1);
        origen[origen.length - 1] = elemento;
        return (origen);
    }

    /**
     * Este método inserta un nuevo elemento en un array ordenado
     *
     * @param array el array ordenado en el que hay que insertar un elemento
     * @param nuevo el nuevo elemento a insertar
     * @return el array nuevo con el elemento insertado
     */
    public static int[] insertarOrdenada(int[] array, int nuevo) {
        int indiceInsercion = Arrays.binarySearch(array, nuevo);
        /* si indiceIsercion >= 0, es el nuevo elemento (que está repetido) se 
        inserta en el lugar que ya estaba, desplazando al original */
        if (indiceInsercion < 0) { // si no lo encuentra
            /* calcula donde debería estar */
            indiceInsercion = -indiceInsercion - 1;
        }
        int copia[] = new int[array.length + 1]; // nueva tabla con longitud + 1
        /* copiamos los elementos antes del "hueco" */
        arrayCopia(array, 0, copia, 0,
                indiceInsercion);
        /* copiamos, desplazando los elementos tras el hueco */
        arrayCopia(array, indiceInsercion, copia,
                (indiceInsercion + 1), (array.length - indiceInsercion));
        copia[indiceInsercion] = nuevo; // asignamos nuevo elemento
        return (copia);
    }

    /**
     * Este método elimina un elemento dentro de un array desordenado (si lo
     * encuentra)
     *
     * @param array el array desordenado donde buscar el elemento
     * @param clave el elemento a borrar
     * @return el nuevo array
     */
    public static int[] eliminarNoOrdenada(int[] array, int clave) {
        int indiceBorrado;
        /* buscamos el índice donde se encuentra el elemento a eliminar */
        indiceBorrado = buscar(array, clave);
        if (indiceBorrado != -1) { // lo ha encontrado
            /* copiamos el elemento final del array en el índice a borrar */
            array[indiceBorrado] = array[array.length - 1];
            /* le restamos uno a la longitud del array */
            array = copiaDe(array, array.length - 1);
        }
        return (array);
    }

    /**
     * Este método elimina un elemento de un array ordenado de enteros
     *
     * @param origen el array donde buscar y eliminar el elemento
     * @param elemento el elemento a eliminar
     * @return el array original con el elemento eliminado
     */
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

    /**
     * Este método compara dos arrays y devuelve 'true' si contiene el mismo
     * número de elementos en el mismo orden, es decir, si ambos arrays son
     * idénticos
     *
     * @param a
     * @param b
     * @return devuelve true si son iguales
     */
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
}
