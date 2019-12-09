/**
 * Created by ybh on 2019/10/21.
 */
public class LeetCode_88_419 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            if(n>0){
                for(int i=0;i<=n-1;i++){
                    nums1[i] = nums2[i];
                }
                return;
            }else{
                return;
            }
        }
        if(n==0){
            return;
        }

        /**
         * 整体思路：从后开始比较，最大的数放到m+n-1的位置即可，
         *  定义两个指针，一个是要放位置的指针，一个是nums1开始循环位置的指针
         */
        int putValueIndex = m + n -1;

        int forNum2=nums2.length-1;
        int forNum1=m - 1;

        while (forNum2>=0 && forNum1>=0){
            if(nums1[forNum1] > nums2[forNum2]){
                nums1[putValueIndex] = nums1[forNum1];
                forNum1--;
            }else {
                nums1[putValueIndex] = nums2[forNum2];
                forNum2--;
            }
            putValueIndex--;
        }
        //完善数组2
        if(forNum1<0 && forNum2>=0){
            for(int i=0;i<=forNum2;i++){
                nums1[i] = nums2[i];
            }
        }

    }
}
