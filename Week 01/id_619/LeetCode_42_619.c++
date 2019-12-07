class Solution {
public:
    int trap(vector<int>& height) {
        int i = 0;
        int j = height.size()-1;
        int left_max = 0;
        int right_max = 0;
        int sum = 0;
        while (i<j) {
            if (height[i]<height[j]) {
                height[i]>left_max ?left_max=height[i]:sum=sum+left_max-height[i];
                i++;
            }else {
                height[j]>right_max ?right_max=height[j]:sum=sum+right_max-height[j];
                j--;
            }
        }
        return sum;
    }
};