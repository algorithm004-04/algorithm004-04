class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int p = m + n -1;
        int p1 = m - 1;
        int p2 = n - 1;

        while(p1 >= 0 && p2 >=0){

            if(nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            }
            else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;

        }

        //当ｐ2大于等于０的时候说明nums2中还有剩余的元素未拷贝，且都是最小值，只需要依次拷贝到nums1的前面即可
        //如果ｐ2先走完为－１,则直接退出该循环
        while(p2+1)
        {
            nums1[p2] = nums2[p2];
            p2--;
        }
    }
};
