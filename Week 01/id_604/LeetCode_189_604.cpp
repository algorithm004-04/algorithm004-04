#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(k <= 0)
            return;

        k %= nums.size();
        printf("k = %d\n",k);
        reverse(nums,0,nums.size()-1);

        reverse(nums,0,k-1);
        reverse(nums,k,nums.size()-1);

    }

    void reverse(vector<int>& nums, int start, int end){
        int temp;
        while(start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

};

