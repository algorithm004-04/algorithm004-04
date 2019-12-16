package week_02.lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCombinationsOfPhoneNumber {

    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    static List<String> output = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {

        if (0 != digits.length()){
            backTrack("",digits);
        }
        return output;
    }

    private static void backTrack(String combination, String nextDigits) {

        if (0 == nextDigits.length()) {
            output.add(combination);
        } else {
            String digit = nextDigits.substring(0,1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i,i + 1);
                backTrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
