public class Leetcode_01_704 {
    public int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                arr[0] = i;
                arr[1] = map.get(target - nums[i]);
                return arr;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}