//递归＋备忘录
class Solution{

private:
    //有重复子问题，采用记忆化搜索
    //memo[i][c]表示使用索引为[0...i]的这些元素，是否可以完全填充一个容量为ｃ的背包
    //-1表示未计算　０表示可以不填充　１表示可以填充
    vector<vector<int>> memo;

    //使用ｎｕｍｓ[0...index]，是否可以填充一个容量为ｓｕｍ的背包
    bool tryPartition(const vector<int> &nums,int index, int sum){
        //退出递归条件
        if( sum == 0)
            return true;

        if( sum < 0 || index < 0)
            return false;

        if( memo[index][sum] != -1 )
            return memo[index][sum] == -1;

        //两种策略不使用index，使用index -1;
        memo[index][sum] =
                ( tryPartition(nums, index -1 , sum) ||
                tryPartition(nums, index-1, sum - nums[index])) ? 1 : 0;

        return memo[index][sum] == 1;
    }

public:
    bool canPartition(vector<int>& nums) {

        int sum = 0;
        for( int i = 0; i < nums.size(); i++ ){
            assert( nums[i] > 0);
            sum += nums[i];
        }

        if( sum%2 != 0 )
            return false;

        memo = vector<vector<int>>(nums.size(), vector<int>(sum/2+1,-1));
        return tryPartition(nums,nums.size()-1,sum/2);

    }
};


