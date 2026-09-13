package lab02.ejercicio01;

import java.util.Scanner;

public class MainInsertionSort {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String[] listaNombres = getListaNombres();
        mostrarListaNombres(listaNombres);
        insertionSort(listaNombres);
        mostrarListaNombres(listaNombres);
    }
    private static String[] getListaNombres() {
        System.out.println("Introduce nombres (separados por espacios): ");
        String listaNombres = sc.nextLine();
        if (listaNombres.isBlank()) {
            System.out.println("Lista vacía");
            return new String[0];
        }
        return listaNombres.trim().split("\\s+");
    }
    private static void mostrarListaNombres(String[] listaNombres) {
        System.out.println("Lista de nombres:");
        for (int i = 0; i < listaNombres.length; i++) {
            System.out.println(i+1+". "+listaNombres[i]);
        }
    }
    public static void insertionSort(String[] lista) {
        for (int i = 1; i < lista.length; i++) {
            for (int j = i; j > 0; j--) {
                if (lista[j].compareTo(lista[j - 1]) < 0) {
                    String temp = lista[j];
                    lista[j] = lista[j - 1];
                    lista[j - 1] = temp;
                }
                else break;
            }
        }
    }
}
