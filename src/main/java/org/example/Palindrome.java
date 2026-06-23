package org.example;

public class Palindrome {

    public String longestPalindromeBruteForce(String s) {
        String best = "";
        for (int ini = 0; ini < s.length(); ini++){
            for (int end = ini; end < s.length(); end++){
                String evalStr = s.substring(ini,end+1);
                if (isPalindrome(evalStr) && evalStr.length()>best.length())
                    best = evalStr;
            }
        }
        return best;
    }

    public boolean isPalindrome(String str) {
        //System.out.println("Analize: " + str);
        char arr[] = str.toLowerCase().toCharArray();
        int l=0, r=str.length()-1;
        while (l<r) {
            if (arr[l++] != arr[r--])
                return false;
        }
        return true;
    }

    public String longestPalindromeExpCenter(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Palíndromos de longitud impar
            int len1 = expandFromCenter(s, i, i);
            // Palíndromos de longitud par
            int len2 = expandFromCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
