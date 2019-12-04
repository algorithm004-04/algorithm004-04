
/*
 *    搜索旋转排序数组 
*/

#include <vector>

using namespace std;

/*
    方法一：二分查找法 
*/
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = int(nums.size()) - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                left = mid + 1;
            else
                right = mid;
        }

        return left == right && nums[left] == target ? left : -1;
    }
};