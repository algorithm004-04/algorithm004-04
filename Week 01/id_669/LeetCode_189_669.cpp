/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (38.89%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    71.6K
 * Total Submissions: 184.1K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
/* 1. 反转
** 这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
** 时间复杂度： 数组n个元素被旋转，O(n)
*/
class Solution {
public:
  void reverse(vector<int>& nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
  void rotate(vector<int>& nums, int k) {
    k = k % nums.size();
    reverse(nums, 0, nums.size()-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, nums.size()-1);
  }
};

/* 2. 环状替换
** 这个方法基于数论中的一个定理，若有两个正整数m、n，且gcd(m, n) = d, 那么序列A{m%n, 2m%n, 3m%n...,nm%n}
** 一定是B{0, d, 2d, 3d, ...., n-d}的某个排列并重复出现d次，%代表求模操作.
**
** 说明:
** 从一个点出发每次走n步，一定能走回原点：
** 假设数组A[1,2,3,4,5,6] k = 2, 使用环状替换则有：
** 1-->3-->5-->1 ------> 5, 2, 1, 4, 3, 6
** 2-->4-->6-->2 ------> 5, 6, 1, 2, 3, 4
** 假设可以走回原点，定义i为走过的位移，则有：
** i % n == 0;
** i % k == 0;
** 这里i(走过的位移)最小为n, k的最小公倍数，设为B。
** 那么回到原点需要走 B / k 步， 需要的循环次数就是 n / (B/k) = nk / B.
** 因为两个数的乘积等于其最大公约数和最小公倍数的乘积，故nk / B 为最大公约数。(nk = (nk/b) * B)。
*/
class Solution {
public:
  void rotate(vector<int>& nums, int k) {
    if (nums.size() <= 1) {
      return;
    }
    // 旋转步数
    int step = k % nums.size();
    // 寻找n和step的最大公约数
    int gcd = findGcd(nums.size(), step);
    int position, count;

    for (int i = 0; i < gcd; i++) {
      // 每次循环的起始位置
      position = i;
      // 需要交换次数
      count = nums.size() / gcd - 1;
      for (int j = 0; j < count; j++) {
          position = (position + step) % nums.size();
          // 交换i和position的值
          // XOR swap
          nums[i] ^= nums[position];
          nums[position] ^= nums[i];
          nums[i] ^= nums[position];
      }
    }
  }

  int findGcd(int a, int b) {
    return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
  }
};


// @lc code=end

