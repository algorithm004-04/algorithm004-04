方法一：暴力法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i)
			for (int j = i + 1; j < nums.length; ++j)
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}

		return new int[] {0};
    }
}

方法二: HashMap
class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int other_num = target - nums[i];
			if (map.containsKey(other_num)) {
				return new int[] { map.get(other_num), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}