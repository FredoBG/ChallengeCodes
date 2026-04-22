package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNums {
    public String getFirstNPrimes(int n) {
        if (n<=0)
            return "Invalid Request";

        System.out.println("Items Requested: "+n);
        // Generate prime list
        List<Integer> lstPrimes = new ArrayList<Integer>();
        for (int i=2; lstPrimes.size()<n; i++){
            if (isPrime(i))
                lstPrimes.add(i);
        }

        // Convert List to Array
        int[] arr=new int[lstPrimes.size()];
        for (int i=0; i<lstPrimes.size(); i++) {
            arr[i]=lstPrimes.get(i);
        }
        return Arrays.toString(arr);
    }

    public boolean isPrime(int n){
        if (n<=1) return false;
        if (n!=2 && n % 2 == 0) return false;

        for (int i=3; i*i <= n; i+=2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
