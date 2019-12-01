package week_07.lesson18;

public class InsertionSort {

    //插入排序
    private static void insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex,current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            //从preIndex位置开始，向前查找，如果前一个元素比后一个元素大，则交换
            while (preIndex > -1 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,7,2,6,5};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
