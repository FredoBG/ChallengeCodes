package org.example;

public class Vowels {
    public String reverseVowels(String s) {
        int l=0, r=s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        String vowels = "aeiouAEIOU";

        while (l<r){
            if (vowels.indexOf(sb.charAt(l))>=0 && vowels.indexOf(sb.charAt(r))>=0){
                char t = sb.charAt(l);
                sb.setCharAt(l, sb.charAt(r));
                sb.setCharAt(r, t);
                l++; r--;
            }
            if (vowels.indexOf(sb.charAt(l))==-1){
                l++;
            }
            if (vowels.indexOf(sb.charAt(r))==-1){
                r--;
            }
        }
        return sb.toString();
    }
}
