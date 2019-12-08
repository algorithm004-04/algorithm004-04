package week_05.lesson12;

public class HouseRobber {


    public static int rob(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        /*int[][] a = new int[n][2];
        a[0][0] = 0;
        a[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            a[i][0] = Math.max(a[i - 1][0],a[i - 1][1]);
            a[i][1] = a[i - 1][0] + nums[i];
        }
        return Math.max(a[n - 1][0], a[n - 1][1]);*/

        if (n == 1) {
            return nums[0];
        }
        int[] a = new int[n];
        a[0] = nums[0];
        a[1] = Math.max(nums[0], nums[1]);
        int result = Math.max(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            a[i] = Math.max(a[i - 1], a[i - 2] + nums[i]);
            result = Math.max(result, a[i]);
        }
        return result;


    }

    public static void main(String[] args) {

    }
}
