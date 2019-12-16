//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //三指针法
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //先将数组排序
        Arrays.sort(nums);
        //定义三个指针k,left,right
        //固定指针k指向头元素，i指向k右边第一个元素，j指向尾元素
        for (int k = 0; k < nums.length - 2; k++) {
            //由于数组已经排序，头元素最小且大于0，则三数之和一定大于0
            if(nums[k] > 0) break;
            //去重：k指向的元素不可重复
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int left = k + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {
//                    List<Integer> ll = new ArrayList<Integer>();
//                    ll.add(num[k]); ll.add(num[left]); ll.add(num[right]);
//                    list.add(ll);
                    //asList：数组转换为list
                    list.add(Arrays.asList(nums[k], nums[left], nums[right]));
                    //lef和right指向的元素也不可重复
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return list;
    }

    //暴力法，由于时间超长，leetcode判定不通过
    public List<List<Integer>> threeSumViolence(int[] nums) {
        List<List<Integer>> l2 = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> l1 = new ArrayList<Integer>();
                        l1.add(nums[i]);
                        l1.add(nums[j]);
                        l1.add(nums[k]);
                        l2.add(l1);
                    }
                }
            }
        }
        for (int m = 0; m < l2.size() - 1; m++) {
            Collections.sort(l2.get(m));
        }
        for (int n = 0; n < l2.size() -2; n++) {
            for (int p = n+1; n < l2.size() -1; n++) {
                if(l2.get(n).equals(l2.get(p))){
                    l2.remove(p);
                }
            }
        }
        return l2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
