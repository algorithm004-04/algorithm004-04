package org.liqi.algorithm;

import java.util.*;

public class LeetCode_17_749 {
    private static final Map<Character, String> mapping = new HashMap<>();
    static {
        mapping.put('2', "abc"); mapping.put('3', "def");
        mapping.put('4', "ghi"); mapping.put('5', "jkl");
        mapping.put('6', "mno"); mapping.put('7', "pqrs");
        mapping.put('8', "tuv"); mapping.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Arrays.asList("");
        List<String> res = new LinkedList<>();

        char[] buf = new char[digits.length()];
        for (int k = 0; k < buf.length; k++)
            buf[k] = mapping.get(digits.charAt(k)).charAt(0);

        int[] idx = new int[digits.length()];
        int i = 0;
        while (i < digits.length()) {
            res.add(new String(buf));
            i = 0;
            while (i < digits.length()) {
                idx[i] = (idx[i] + 1) % mapping.get(digits.charAt(i)).length();
                buf[i] = mapping.get(digits.charAt(i)).charAt(idx[i]);
                if (idx[i] != 0) break;
                i++;
            }
        }
        return res;
    }
}
