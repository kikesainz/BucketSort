package com.kike.bucketsort.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class BucketSort {

    // Función principal para Bucket Sort
    public static void bucketSort(double[] arr) {
        int n = 10;


        // 1. Crear una matriz de casilleros (buckets) 
        // Cada elemento del arrayList buckets tendrá un arrayList
        List<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2. Asignar elementos a los casilleros
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        // 3. Ordenar cada casillero (usando otro algoritmo, como Insertion Sort)
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4. Combinar los casilleros para obtener la lista ordenada
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index] = buckets[i].get(j);
                index++;
            }
        }
    }

    // Función de utilidad para imprimir un array
    public static void printArray(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        double[] arr = {0.42, 0.72, 0.11, 0.45, 0.91, 0.01, 0.78, 0.63};

        System.out.println("Array original:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
