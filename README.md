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
Este método muestra por terminal un _array_ con sus elementos entre corchetes y separados por guiones. Si se incluyen valores negativos entre los elementos, la salida puede resultar algo confusa:
```
public static void muestraArray(int[] array) {
    System.out.print("[");
    for (int i = 0; i < array.length; i++) {
        if (i == (array.length - 1)) {
            System.out.print(array[i]);
        } else {
            System.out.print(array[i] + " - ");
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

```
```
### insertarOrdenada

```
```
### eliminarNoOrdenada

```
```
### eliminarOrdenada

```
```
### iguales 

```
```

## Implementación en el código

## Testeo

