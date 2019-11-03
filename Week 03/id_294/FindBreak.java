package week03;

public class FindBreak {

    /**
     * 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
     * 思路：找最小值
     * @param arr
     */
    public static int findBreak(int[] arr) {
        int length = arr.length;
        if (arr[0] < arr[length-1]) {
            return -1;
        }
        int left = 0;
        int right = length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int index = findBreak(arr);
        System.out.println("index " + index);
    }
}
