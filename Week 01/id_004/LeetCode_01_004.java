import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        //Value -> Index
        HashMap<Integer, Integer> map = new HashMap<>();
        int result[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != i){
                result[0] = i;
                result[1] = map.get(remain);
                return result;
            }
        }

        return result;

    }
}