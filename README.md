# Biblioteca Arrays de Java
Este repositorio contiene funciones propias desarrolladas en Java para el manejo de _arrays_ de números enteros, imitando métodos existentes de la clase `Arrays`. La principal función del código del presente repositorio es entender mejor el funcionamiento de estos métodos y practicar algoritmia básica con _arrays_.

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
Este método busca un elemento en un array de enteros, devolviendo la posición donde lo ha encontrado, o un -1 si ese elemento no se encuentra en el array:
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
Este método muestra por terminal un array con sus elementos entre corchetes y separados por guiones. Si se incluyen valores negativos entre los elementos, la salida puede resultar algo confusa:
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

muestraArray(int[] array);
copiaDe(int[] origen, int longitud);
copiaDeRango(int[] origen, int desde, int hasta);
arrayCopia(int[] origen, int posicionOrigen, int[] destino, int posicionDestino, int longitud);
insertarNoOrdenada(int[] origen, int elemento);
insertarOrdenada(int[] array, int nuevo);
eliminarNoOrdenada(int[] array, int clave);
eliminarOrdenada(int[] origen, int elemento);
iguales(int[] a, int[] b);

## Implementación en el código

## Testeo

