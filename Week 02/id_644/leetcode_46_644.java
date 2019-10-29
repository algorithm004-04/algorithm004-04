package com.company;
/*
*给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
 */
import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {

    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrace(res,new ArrayList<>(),nums);
        return res;
    }

    //回溯
    public void backtrace(List<List<Integer>> res,List<Integer> temp,int[] nums){
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        else{
            for(int i= 0;i <nums.length; i++) {
                if(temp.contains(nums[i])) continue;
                temp.add(i);
                backtrace(res,temp,nums);
                temp.remove(temp.size() -1);

            }
        }
    }
}
