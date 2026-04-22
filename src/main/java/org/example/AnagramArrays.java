package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramArrays {
    public boolean areAnagrams(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countFreq = new HashMap<>();

        System.out.println("Array1: "+Arrays.toString(arr1));
        System.out.println("Array2: "+ Arrays.toString(arr2));

        if (arr1.length != arr2.length)
            return false;

        // Count frequency in arr1
        for (int val : arr1) {
            countFreq.put(val, countFreq.getOrDefault(val, 0)+1);
        }

        // Verify arr2 against arr1
        for (int val : arr2) {
            if (!countFreq.containsKey(val))
                return false;
            countFreq.put(val, countFreq.get(val)-1);
            if (countFreq.get(val)==0)
                countFreq.remove(val);
        }
        return countFreq.isEmpty();
    }
}
