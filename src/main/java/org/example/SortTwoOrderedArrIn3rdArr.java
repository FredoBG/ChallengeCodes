package org.example;

import java.util.Arrays;

public class SortTwoOrderedArrIn3rdArr {
    public void sort(int[] arr1, int[] arr2) {
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        int i=0, j=0, k=0;
        int[] arr3 = new int[arr1.length + arr2.length];

        while (i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        while (i<arr1.length) {
            arr3[k++] = arr1[i++];
        }

        while (j<arr2.length) {
            arr3[k++] = arr2[j++];
        }

        System.out.println("Array 3: " + Arrays.toString(arr3));
    }
}
