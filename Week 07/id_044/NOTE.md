# NOTE
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

//选择排序
    private static void selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex,temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

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






  

