package org.example;

import java.util.Arrays;

public class Fibonacci {
    public String firstFibN(int n) {
        System.out.println("Requested items: "+n);
        if (n<=0)
            return "Invalid request";
        int[] fibN = new int[n];

        for (int i=0; i<=n-1; i++) {
            if (i<=1)
                fibN[i]=i;
            else
                fibN[i]=fibN[i-1]+fibN[i-2];
        }
        return Arrays.toString(fibN);
    }
}
