#include <iostream>
#include <vector>
#include <stack>
#include <assert.h>
using namespace std;

//LeetCode 46题 Permutation
/*
 * 递推公式
 * Perms(nums[0...n-1]) = {取出一个数字} + Perms(nums{0...n-1}-这个数字)；
 * 注意：一旦取出了一个数字,它就会影响在递归的调用Permutation的时候，所要处理的数据范围
 */
//回溯法是暴力解法的一个主要手段


class Solution {

private:
    vector<vector<int>> res;
    vector<bool> used;
    //p中保存了一个有index个元素的索引
    //向这个排列末尾添加第index+1个元素，获得一个index+1个元素的排列
    void generatePermutation(const vector<int>& nums, int index, vector<int>& p){
        //递归的推出条件，可以理解为是用回溯算法找到的一组解(一个排列)
        cout << index << " : ";
        for(int i = 0; i < p.size();i++){
            cout << p[i];
        }
        cout << endl;

        if( index == nums.size()){
            res.push_back(p);
            cout << "get ";
            for(int i = 0; i < p.size();i++){
                cout << p[i];
            }
            cout << endl;
            return;
        }
        //p中已经有了index个元素，对于这index元素我们不能重复使用
        //所以要看下nums[i]是否在p中，如果不在才可以进行后续的逻辑--即nums[i]添加到p中
        for( int i = 0; i < nums.size(); i++ ){
            if(!used[i]){

                //将nums[i]添加在p中
                p.push_back( nums[i] );
                used[i] = true;
                cout<<"used["<<index<<"]"<<"=true" <<endl;
                for(int i = 0; i < p.size();i++){
                    cout << p[i];
                }
                cout << endl;
                cout<<"Permutation["<<index<<"] = "<< nums[i]<<" complete, return" <<endl;
                generatePermutation(nums,index+1,p);
                //恢复原状，在进行下一步的回溯尝试
                //设置的递归函数能够保证回去，设置的变量要看是否有必要，如果有必要也要回到原位
                p.pop_back();
                used[i] = false;
                cout<<"used["<<index<<"]"<<"=false" <<endl;
            }
        }

        return;
    }


public:
    vector<vector<int>> permute(vector<int>& nums) {
        res.clear();
        if( nums.size() == 0 )
            return res;

        vector<int> p;
        used = vector<bool >(nums.size(), false);
        generatePermutation(nums,0,p);

        return res;

    }
};

int main(void)
{

    vector < int > v = {1,2,3};
    vector<vector<int>> res = Solution().permute(v);
    for(int i = 0 ; i < res.size(); i++){
        for(int j = 0 ; j < res[i].size(); j++){
            cout << res[i][j];
        }
        cout << endl;
    }


    return 0;
}




