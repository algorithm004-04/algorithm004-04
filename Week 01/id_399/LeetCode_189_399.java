class Solution {
    public void rotate(int[] nums, int k) {
    	if ((k = k > nums.length ? k % nums.length : k) != nums.length && k > 0) {
    		int[] ks = new int[k];
    		System.arraycopy(nums, nums.length - k, ks, 0, k);
    		System.arraycopy(nums, 0, nums, k, nums.length - k);
    		System.arraycopy(ks, 0, nums, 0, k);
		}
    }
}