package week_01;

public class RainWater {

    public static int trap(int[] height) {
        //双指针，分别在第一个位置和最后一个位置
        int left = 0, right = height.length - 1;
        int result = 0;     //结果
        int left_max = 0, right_max = 0;    //左边最大的数，右边最大的数
        while (left < right) {      //如果左下标小于右下标，则继续处理
            //如果左边的值小于右边的值
            if (height[left] < height[right]) {
                //且左边的值大于等于左边的最大值
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {    //如果小于，左边的最大值减去左边的值
                    result += (left_max - height[left]);
                }
                left++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    result += (right_max - height[right]);
                }
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
