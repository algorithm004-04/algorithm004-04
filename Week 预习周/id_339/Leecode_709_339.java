package com.codertoy.week08;

public class Leecode_709_339 {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                sb.setCharAt(i,(char)(c+32));
            }
        }
        return sb.toString();
    }
}
