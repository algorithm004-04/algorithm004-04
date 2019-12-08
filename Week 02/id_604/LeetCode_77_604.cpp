//LeetCode 77题 Combinations
/*树形问题 --- 使用回溯算法求解组合问题
 *回溯法的剪枝
 */

class Solution {
private:
    vector<vector<int>> res;
    //求解C(n,k),当前已经找到的组合储存在c中，需要从start开始搜索新的元素
    void generateCombinations(int n, int k, int start, vector<int> &c){
        //递归的结束条件
        if(c.size() == k){
            res.push_back(c);
            return;
        }

        //还有k - c.size()个空位，所以，[i...n]中至少要有k-size()个元素
        //i最多为 n - (k - c.size()) + 1
        //for(int i = start; i <= n; i++){
        for(int i = start; i <= n - (k - c.size()) + 1 ; i++){//进行剪枝优化
            c.push_back(i);
            generateCombinations(n,k,i+1,c);
            //然后下面是回溯的过程,要清除上一步留下来的状态
            c.pop_back();
        }

    }

public:
    vector<vector<int >> combine(int n, int k){
        res.clear();
        if(n <= 0 || k <= 0 || k > n){//排除掉不正常的输入
            return  res;
        }

        vector<int> c;
        generateCombinations(n,k,1,c);

        return res;

    }

};
