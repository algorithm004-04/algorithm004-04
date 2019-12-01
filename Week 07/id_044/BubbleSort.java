package week_07.lesson18;

public class BubbleSort {

    //冒泡排序
    private static void bubbleSort(int[] arr) {

        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,7,2,6,5};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
