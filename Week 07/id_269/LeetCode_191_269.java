/*
* 191. 位1的个数
* 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
* */
public class LeetCode_191_269 {
    /**
     * 清零最低位的1，有几个1就循环几次
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

    /**
     * 位运算直接往后移动，32位系统运行32次
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n = n >>> 1;
        }
        return count;
    }
}
