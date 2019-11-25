package algorithm;

import java.util.Arrays;

public class LeetCode_455_299 {
    public static int findContentChildren(int[] g, int[] s) {
        int max=0;
        Arrays.sort(g);
        Arrays.sort(s);
        // 先满足最小胃口的小孩
        for(int i = 0,j =0;i< g.length && j<s.length;){
            if(g[i]<= s[j]){
                i++;
                j++;
                max++;
            }else { // 不能满足 则选择下一个饼干
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};
        int max = LeetCode_455_299.findContentChildren(g,s);
        System.out.println("max------->"+max);
    }
}
