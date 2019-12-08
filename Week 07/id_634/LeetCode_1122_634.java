class Solution {
    //1 计数排序 Conting Sort
    // public int[] relativeSortArray(int[] arr1, int[] arr2) {
    //     int[] count = new int[1001];
    //     // 遍历arr1中的元素并计数
    //     for (int num : arr1) {
    //         count[num]++;
    //     }
    //     int index = 0;
    //     // 处理arr2中的元素
    //     for (int num : arr2) {
    //         while (count[num] > 0) {
    //             arr1[index++] = num;
    //             count[num]--;
    //         }
    //     }
    //     // 处理剩余不是arr2中的元素
    //     for (int i = 0; i < count.length; i++) {
    //         while (count[i] > 0) {
    //             arr1[index++] = i;
    //             count[i]--;
    //         }
    //     }
    //     return arr1;
    // }
    
    //2 桶排序 Bucket Sort
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Bucket for 0 <= arr element <= 1000
        int[] bucket = new int[1001];
        
        int[] result = new int[arr1.length];
        int index = 0;
        
        // 遍历arr1中的元素并装入桶
        for(int i : arr1) {
            bucket[i]++;
        }
        
        // 处理arr2中的元素
        for(int i : arr2) {
            while(bucket[i]-- > 0) {
                result[index++] = i;
            }
        }
        
        // 处理剩余不是arr2中的元素
        for(int i = 0; i < 1001; i++){
            if(bucket[i] > 0) {
                while(bucket[i]-- > 0) {
                    result[index++] = i;
                }
            }
        }
        return result;
    }
    
}