package algorithm;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
//        int[] index = sum(nums, 9);
        int[] index = sum2(nums,6);
        for (int i =0; i<index.length;i++){
            System.out.print(index[i]+" ");
        }
    }

    // 暴力
    public static int[] sum(int[] nums, int target){
     for (int i = 0; i < nums.length; i++) {
         for (int j = i + 1; j < nums.length; j++) {
             if (nums[i] + nums[j] == target) {
                 return new int[] { i, j };
             }
         }
     }
     throw new IllegalArgumentException("没有找到值");
    }

    /**
     * 把每次遍历没有找到的值存入map中，待下次取值
     * @param nums
     * @param target
     * @return
     */
    public static int[] sum2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (int i =0;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.containsKey(diff) && map.get(diff)!= i){
                return new int[]{i, map.get(diff)};
            }
        }
        throw new IllegalArgumentException("没有找到值");
    }
}

