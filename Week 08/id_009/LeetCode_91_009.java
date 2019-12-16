/**
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class LeetCode_91_009 {
    public static void main(String[] args) {
        LeetCode_91_009 test=new LeetCode_91_009();
        System.out.println(test.numDecodings("12"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || "0".equals(s)) {
            return 0;
        }
        int join = 0;
        int notJoin = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                System.out.println(s.charAt(i - 1));
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                } else {
                    join = notJoin;
                    notJoin = 0;
                }
            } else {
                int temp = Integer.parseInt(s.substring(i - 1, i + 1));
                if (s.charAt(i - 1) == '0') {
                    notJoin = join;
                    join = 0;
                } else if (0 < temp && temp < 27) {
                    temp = join;
                    join = notJoin;
                    notJoin += temp;
                } else {
                    notJoin += join;
                    join = 0;
                }
            }

        }
        return join + notJoin;
    }

}
