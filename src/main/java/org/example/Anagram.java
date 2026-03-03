package org.example;

import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() < 1 || t.length() < 1 || s.length() != t.length())
            return false;

        int[] charArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'a']++;
            charArr[t.charAt(i) - 'a']--;
        }

        for (int c : charArr) {
            if (c != 0)
                return false;
        }
        return true;
    }
}
