package com.codertoy.week08;

public class Leecode_151_339 {
    public String reverseWords(String s) {
        String emptyStr=" ";
        final String[] s1 = s.trim().split(emptyStr);
        StringBuilder sb=new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            String str=s1[i];
            while (str.contains(emptyStr)){
                str=str.replaceAll(emptyStr,"");
            }
            if ("".equals(str)){
                continue;
            }
            sb.append(str);
            if (i!=0){
                sb.append(emptyStr);
            }
        }
        return sb.toString();
    }
}
