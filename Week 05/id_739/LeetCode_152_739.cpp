class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int _max = INT_MIN, imax = 1, imin = 1;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = max(imax*nums[i], nums[i]);
            imin = min(imin*nums[i], nums[i]);
            _max = max(imax, _max);
        }
        return _max;
    }
};
