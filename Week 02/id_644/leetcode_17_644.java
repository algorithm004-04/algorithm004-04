package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombination {
    public static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
            String test ="23";
        System.out.println( letterCombination(test));
            System.out.println(res);
    }
    public static List<String> letterCombinations(String digits) {

        if(digits.length() ==0)
            return res;
        recur(digits,"");
        return  res;
    }
    public static void recur(String digits,String temp){
        if(digits.length() ==0) {
            res.add(temp);

        }
        else{
            String dtemp = digits.substring(0,1);
            String alphs = phone.get(dtemp);
            for(int i =0 ;i < alphs.length();i++) {
                String subaplph = alphs.substring(i,i+1);
                recur(digits.substring(1),temp+subaplph);
            }
        }

    }
}
