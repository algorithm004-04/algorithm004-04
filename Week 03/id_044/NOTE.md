# NOTE

1.进行二分查找的前提
    (1).目标函数的单调性(单调递增或者递减))
    (2).存在上下界
    (3).能够通过索引访问

2.代码模版
int left, right = 0, len(array) - 1;
while (left <= right) {
    mid = (left + right) / 2;
    if (array[mid] == target) {
        return result;
    } else if (array[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}

3.使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
本题重点是如何知道要找的值的区域是否被旋转，根据二分查找的定义，要查找的值只可能是在[low,mid]和[mid+1,high]中
    (1).如果在[low,mid]中，数组是有序的，那么nums[0] <= nums[mid],当target > nums[mid] || target < nums[0],说明不在当前区域，到[mid+1,high]中查找
    (2).如果在[low,mid]中，数组是旋转了，那么nums[0] > nums[mid],当target < nums[0] && target > nums[mid]，说明要找的值不在当前区域，到[mid+1,high]中查找
    (3).其它的情况就在[low,mid]中查找

4.代码
public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                low = mid + 1;
            } else if(target > nums[mid] && target < nums[0]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low == high && nums[low] == target) {
            return low;
        } else {
            return -1;
        }
    }
