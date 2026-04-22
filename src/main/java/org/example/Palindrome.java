package org.example;

public class Palindrome {
    public boolean isPalindrome(String str) {
        System.out.println("Analize: " + str);
        char arr[] = str.toLowerCase().toCharArray();
        int l=0, r=str.length()-1;
        while (l<r) {
            if (arr[l] != arr[r])
                return false;
            l++; r--;
        }
        return true;
    }
}
