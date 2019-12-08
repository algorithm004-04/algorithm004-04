package SuanFa.Week02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_17_574 {
    public static List<String> list = new ArrayList<>();
    public static String[] str1 = {"a","b","c"};
    public static String[] str2 = {"d","e","f"};
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        generate(m,n);
        System.out.println(list);

    }

    private static void generate(int m,int n) {
        int left = 0;
        int right = 0;
        String str = "";
        generateK(left,right,str);
    }

    private static void generateK(int left, int right,String str) {
        if (left + right == 2) {
            list.add(str);
        }
        if (left < 1) {
            for (int i= 0; i<str1.length;i++) {
                generateK(left+1,right,str+str1[i]);
            }
        }
        if (right < left) {
            for (int i= 0; i<str2.length;i++) {
                generateK(left,right+1,str+str2[i]);
            }
        }
    }

}
