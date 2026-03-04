package org.example;

public class Vowels {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arrS = s.toCharArray();
        char aux;
        int l = 0, r = s.length()-1, chg = 0;

        System.out.println("Reversing vowels in: " + s);
        while (l < r){
            if (vowels.indexOf(s.charAt(l)) == -1){
                l++;
            } else {
                chg++;
            }
            if (vowels.indexOf(s.charAt(r)) == -1){
                r--;
            } else {
                chg++;
            }
            if (chg==2){
                aux = arrS[l];
                arrS[l] = arrS[r];
                arrS[r] = aux;
                l++;
                r--;
            }
            chg=0;
        }
        return new String(arrS);
    }
}
