// 第一种方法： 暴力求解
//class Solution {
//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int minHeight = Math.min(height[i], height[j]);
//                int area = (j - i) * minHeight;
//                maxArea = Math.max(maxArea, area);
//            }
//        }
//
//        return maxArea;
//    }
//}

// 第二种方法： 双向逼近
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
             // 因为前面的 i++ 和 j--， 所以宽度需要 + 1
            maxArea = Math.max(maxArea, minHeight * (j - i + 1));
        }

        return maxArea;
    }
}