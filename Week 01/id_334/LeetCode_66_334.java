package Array;
//Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
//
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
// You may assume the integer does not contain any leading zero, except the number 0 itself.
//
// Example 1:
//
//
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//
//
// Example 2:
//
//
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// Related Topics Array


// 第一个想法V1：+1就是分情况讨论:
//              1) 全是9，则长度必须+1&首位为1&其他为0
//              2）直到遍历到不是9的元素，则该元素+1，他后面的都是0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_66_334 {

    public static void main(String[] args) {
        int[] digits = new int[]{6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3};
        System.out.println(Arrays.toString(plusOneV1(digits)));
    }

    public static int[] plusOneV1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //1）直到遍历到不是9的元素，则该元素+1，他后面的都是0
            if (digits[i] != 9){
                ++ digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        //2）直到遍历到不是9的元素，则该元素+1，他后面的都是0
        int [] growArr = new int[digits.length + 1];
        growArr[0] = 1;
        return growArr;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
