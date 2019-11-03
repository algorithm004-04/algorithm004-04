package leetcode.permute;

import java.util.ArrayList;
import java.util.List;

/*46. 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。*/
public class Solution {
	
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        getAllPermutation(results,result,nums,0);
        return results;
    }
                       
    public void getAllPermutation(List<List<Integer>> results,List<Integer> result,int[] nums,int index){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<Integer>(result);
            results.add(temp);
        }
        else{
           for(int i = 0;i <= result.size();i++){
                if(i == result.size()){
                    result.add(nums[index]);
                }
                else{
                    result.add(i,nums[index]);
                }
                getAllPermutation(results,result,nums,index+1);
                result.remove(i);
           }
        }   
    }
}
