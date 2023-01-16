package biblioteca.arrays;

import static biblioteca.arrays.BibliotecaArrays.*;

/**
 * Este programa será utilizado para probar la clase bibliotecaArrays
 *
 * @author Adriano Díaz Benítez <Adriano.Díaz>
 */
public class TestBibliotecaArrays {

    public static void main(String[] args) {
        int[] origenOrdenda = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int[] origenDesordenado = {4, 8, 2, 9, 7, 1, 5, 10, 3, 6};

        System.out.println("------------- TESTEANDO copiaDe() -------------");
        System.out.println("Array original: ");
        muestraArray(origenOrdenda);
        int[] destino1 = copiaDe(origenOrdenda, 15);
        System.out.println("Array copiado (mayor longitud): ");
        muestraArray(destino1);
        destino1 = copiaDe(origenOrdenda, 3);
        System.out.println("Array copiado (menor longitud): ");
        muestraArray(destino1);
        System.out.println("---------- TESTEANDO copiaDeRango() ----------");
        System.out.println("Array original: ");
        muestraArray(origenOrdenda);
        destino1 = copiaDeRango(origenOrdenda, 4, 8);
        System.out.println("Array copiado: ");
        muestraArray(destino1);
        System.out.println("----------- TESTEANDO arrayCopia() -----------");
        int[] destino2 = new int[10];
        System.out.println("Arrays originales: ");
        muestraArray(origenOrdenda);
        muestraArray(destino2);
        arrayCopia(origenOrdenda, 2, destino2,
                4, 4);
        System.out.println("Array modificado: ");
        muestraArray(destino2);
        System.out.println("------- TESTEANDO insertarNoOrdenada() -------");
        System.out.println("Array original: ");
        muestraArray(origenDesordenado);
        System.out.println("Array con nuevo elemento: ");
        origenDesordenado = insertarNoOrdenada(origenDesordenado,
                42);
        muestraArray(origenDesordenado);
        System.out.println("-------- TESTEANDO insertarOrdenada() --------");
        System.out.println("Array original: ");
        muestraArray(origenOrdenda);
        System.out.println("Array con nuevo elemento: ");
        origenOrdenda = insertarOrdenada(origenOrdenda, 6);
        muestraArray(origenOrdenda);
        System.out.println("------- TESTEANDO eliminarNoOrdenada() -------");
        System.out.println("Array original: ");
        muestraArray(origenDesordenado);
        System.out.println("Array sin elemento: ");
        origenDesordenado = eliminarNoOrdenada(origenDesordenado,
                42);
        muestraArray(origenDesordenado);
        System.out.println("-------- TESTEANDO eliminarOrdenada() --------");
        System.out.println("Array original: ");
        muestraArray(origenOrdenda);
        System.out.println("Array sin elemento: ");
        origenOrdenda = eliminarOrdenada(origenOrdenda, 6);
        muestraArray(origenOrdenda);
        System.out.println("------------- TESTEANDO iguales() -------------");
        System.out.println("Arrays a comparar: ");
        muestraArray(origenOrdenda);
        muestraArray(origenDesordenado);
        System.out.println("¿Son iguales? "
                + iguales(origenOrdenda, origenDesordenado));
        System.out.println();
        System.out.println("Arrays a comparar: ");
        muestraArray(origenOrdenda);
        origenDesordenado = copiaDe(origenOrdenda, 9);
        muestraArray(origenDesordenado);
        System.out.println("¿Son iguales? "
                + iguales(origenOrdenda, origenDesordenado));
    }
}
