
/*
	方法一： 暴力法

	时间复杂度：O(n * k) 空间复杂度：O(1)
*/

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (0 == nums.size())
            return 0;
        
        int i = 0;
        
        for (int j = 1; j < nums.size(); j++){
            if (nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        
        return i + 1;     
    }
};

/*
	方法二：反转

	时间复杂度：O(n) 空间复杂度：O(1)
*/

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin() + k);
        reverse(nums.begin() + k, nums.end());
    }
}; 


/*
	方法三

	时间复杂度：O(n) 空间复杂度：O(1)
*/

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size(), start = 0;
        
        for (; k %= n; n -= k, start += k) {
            for (int i = 0; i < k; i++) {
                swap(nums[start + i], nums[start + n - k + i]);
            }
        }
    }
};  
