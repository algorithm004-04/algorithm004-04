package medium;

public class LC22 {
    public static void main(String[] args) {
        generateParententhesis(3);
    }

    private static void generateParententhesis(int n) {
        _generate(0,0,n, "");
    }

    private static void _generate(int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }

        //process current logic
        //每一层要么增加(，要么增加),想不通的是为什么使用两个generate
//        String s1 = s + "(";
//        String s2 = s + ")";

        //drill down
        if (left < n)
            _generate(left+1,right, n, s + "(");

        if (left > right)
            _generate(left,right + 1, n, s + ")");

        //reverse state
    }
}
