//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1, right = x;
        //关键点：此处判断必须带上等号
        while (left <= right) {
            int mid = left + (right - left) / 2;
//            if (mid * mid == x) return mid;
            //此处将mid除过去，防止乘积过大溢出
            if (mid > x / mid) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
