package week_03.lesson10;

import java.util.Arrays;

public class AssignCookies {


    public static int findContentChildren(int[] g, int[] s) {

        //贪心算法
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return j;

    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
