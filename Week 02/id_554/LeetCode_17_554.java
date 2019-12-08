package com.kkkkkk.demovvorld.leetcode17;

import java.util.*;

public class Solution {
    public static final Map<Character, String> PHONE = new HashMap<>();

    static {
        PHONE.put('2', "abc");
        PHONE.put('3', "def");
        PHONE.put('4', "ghi");
        PHONE.put('5', "jkl");
        PHONE.put('6', "mno");
        PHONE.put('7', "pqrs");
        PHONE.put('8', "tuv");
        PHONE.put('9', "wxyz");
    }

    private List<String> rst = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            letterCombinations(0, digits.length() - 1, digits, "");
        }
        return rst;
    }

    /**
     * 递归拼接
     *
     * @param cur     当前digit
     * @param max     最大digit
     * @param digits
     * @param letters 递归中结果集
     * @return
     */
    private void letterCombinations(int cur, int max, String digits, String letters) {
        // terminate
        if (cur > max) {
            rst.add(letters);
            return;
        }

        // process
        char digit = digits.charAt(cur);
        String digit2LetterStr = PHONE.get(digit);
        for (Character letter : digit2LetterStr.toCharArray()) {
            // recursive
            letterCombinations(cur + 1, max, digits, letters + letter);
        }

        // reverse state
    }

    public static void main(String[] args) {
//        String digits = "23";
        String digits = "";

        System.out.println(new Solution().letterCombinations(digits));

    }
}
