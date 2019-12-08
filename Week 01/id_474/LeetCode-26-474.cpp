
/*
	时间复杂度：O(n) 空间复杂度：O(1)
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