package algorithm;

public class LeetCode_69_299 {
    public static int mySqrt(int x) {
        // 1.边界终止条件
        if(x==0 || x ==1){
            return x;
        }
        // 2.定义上下界
        long left =1;
        long right = x/2 +1;

        while(left <= right){
            // 3.取中间值
            // long mid = (right + left)/2; // 这里 大数相加的时候可能会溢出
            // 以下是处理方式
            // long mid = left + (right - left)/2; // 不使用加法
            long mid = (left + right) >>> 1; // 无符号 位运算

            if(mid * mid > x){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }
    public static void main(String[] args) {
        int a = 2147395599; // 特俗用例
        int i = LeetCode_69_299.mySqrt(a);
        int b = (int) Math.sqrt(a);

        System.out.println("i=====>"+i);
        System.out.println("b=====>"+b);
    }
}
