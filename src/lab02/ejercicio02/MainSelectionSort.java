package lab02.ejercicio02;

import java.util.Random;

public class MainSelectionSort {
    private static Random rand = new Random();
    private final static int CANTIDAD_NUMEROS = 1000;

    public static void main(String[] args) {
        float[] listaNumeros = generarListaFloat(CANTIDAD_NUMEROS);
        System.out.println("Cantidad de numeros: "+CANTIDAD_NUMEROS);
        selectionSort(listaNumeros);
    }

    private static void selectionSort(float[] listaNumeros) {
        int comparaciones = 0;
        int intercambios = 0;

        for (int i = 0; i < listaNumeros.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < listaNumeros.length; j++) {
                comparaciones++;
                System.out.println("Comparación: " + listaNumeros[j] +
                                " < " + listaNumeros[indiceMenor] );
                if (listaNumeros[j] < listaNumeros[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                System.out.println( "Intercambio: " + listaNumeros[i] +
                                " ↔ " + listaNumeros[indiceMenor] );
                float temporal = listaNumeros[i];
                listaNumeros[i] = listaNumeros[indiceMenor];
                listaNumeros[indiceMenor] = temporal;

                intercambios++;
            }
        }

        System.out.println("\n--- RESULTADO ---");
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);
    }

    private static float[] generarListaFloat(int cantidad) {
        float[] listaNumeros = new float[cantidad];
        for (int i = 0; i < cantidad; i++) {
            listaNumeros[i] = rand.nextFloat();
        }
        return listaNumeros;
    }
}
