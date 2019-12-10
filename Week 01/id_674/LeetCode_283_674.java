//双指针替换0
class Solution {
	public void moveZeroes(int[] nums) {

		int j = 0; // none zero index
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				if (i != j) {
					nums[i] = 0;
				}
				j++;
			}
		}
	}
}