import java.util.Arrays;

public class LeetCode_455_034 {

    public int findContentChildren(int[] g, int[] s) {
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        for (int i = 0; i < s.length && res < g.length; i ++) {
            if (g[res] <= s[i]) {
                res ++;
            }
        }
        return res;
    }
}
