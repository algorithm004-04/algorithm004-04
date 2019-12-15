class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        /*    //暴力 
        vector<int> result;
        for(int i=0;i<nums.size();++i){
            for(int j=i+1;j<nums.size();++j){
                if(nums[i]+nums[j]==target){
                    result.push_back(i);
                    result.push_back(j);
                    break;
                }
            }
        }
        // */
		
		// 映射
        map<int,int> mapNums;
        for(int i=0;i<nums.size();++i){    
            int num = nums[i];
            int diffNum = target-num;
            if(mapNums.find(diffNum)!=mapNums.end()){
                result.push_back(i);
                result.push_back(mapNums[diffNum]);
                break;
            }else{
                mapNums[num]=i;
            }
        }
        return result;
    }
};