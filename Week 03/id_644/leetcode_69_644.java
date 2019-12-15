package week03;

/**69
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 二分查找
 * 目标函数单调性
 * 存在上下界
 * 能通过索引访问
 *
 * template
 * left, right = 0, len(array) - 1
 * while left <= right:
 * 	  mid = (left + right) / 2
 * 	  if array[mid] == target:
 * 		    # find the target!!
 * 		    break or return result
 * 	  elif array[mid] < target:
 * 		    left = mid + 1
 * 	  else:
 * 		    right = mid - 1
 */
public class sqrt {
    public static void main(String[] args) {


    }
    //newton
    public int mySqrt_new(int x) {
        long r =x;
        while (r*r >= x)
            r =(r+x/r)/2;
    return (int)r;
    }

    //binary search
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int l = 1, r = x, res=0;
        while(l <= r){
            int m = (l + r)/2;
            if(m == x / m){
                return m;
            }else if(m > x/m){  //如果有用 m*m 容易超出范围
                r = m - 1;
            }else{
                l = m + 1;
                res = m;
            }
        }
        return res;
    }
    }


