package lab02.ejercicio03;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random rand = new Random();
    private final static int CANTIDAD_NUMEROS = 1000;

    public static void main(String[] args) {
        int[] datos = generadorNumeros();
        String tipoOrdenamiento = "insertion";
        selectorSort(datos, tipoOrdenamiento);
    }

    private static int[] generadorNumeros() {
        int[] listaNumeros = new int[CANTIDAD_NUMEROS];
        for (int i = 0; i < CANTIDAD_NUMEROS; i++) listaNumeros[i] = rand.nextInt(100);
        return listaNumeros;
    }

    private static void selectorSort(int[] datos, String tipoOrdenamiento) {
        if (tipoOrdenamiento.equalsIgnoreCase("insertion")) {
            insertionSort(datos);
        }
        else if (tipoOrdenamiento.equalsIgnoreCase("selection")) {
            selectionSort(datos);
        }
        else {
            System.out.println("Tipo Ordenamiento: insertion, selection");
        }
    }

    private static void selectionSort(int[] datos) {
        for (int i = 0 ; i < datos.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = datos[i];
            datos[i] = datos[indiceMenor];
            datos[indiceMenor] = temp;
        }
    }

    private static void insertionSort(int[] datos) {
        for (int i = 1 ; i < datos.length ; i++) {
            for (int j = i ; j > 0 ; j--) {
                if  (datos[j] < datos[j-1]) {
                    int temp = datos[j];
                    datos[j] = datos[j-1];
                    datos[j-1] = temp;
                }
            }
        }
    }
}
