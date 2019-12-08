
public class Leetcode_88_704{

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0){
            return;
        }
        if(m == 0){
            for(int i = 0; i < n ; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int k = 0;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0;){

             if (nums1[i] <= nums2[j]){
                 nums1[i + j + 1] = nums2[j];
                 j--;
                 if(j == -1){
                 break;
                 }
             }else {
                 nums1[i + j + 1] = nums1[i];
                 i--;
                 if(i == -1){
                 k = j;
                 System.arraycopy(nums2, 0, nums1, 0, k + 1);
                 break;
                 }
             }
        }

        // System.arraycopy(nums2, 0, nums1, 0, k + 1);
    }

}
