package algorithm.homework.week07;


import com.alibaba.fastjson.JSONObject;

/**
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1122_374 {
    public static void main(String[] args) {
        LeetCode_1122_374 leetCode_1122_374 = new LeetCode_1122_374();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};

        System.out.println(JSONObject.toJSONString(leetCode_1122_374.relativeSortArray(arr1, arr2)));
    }

    /**
     * 暴力+快排
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] tmp = new int[arr1.length - arr2.length];
        int p = 0;
        int q = 0;
        for (int i = 0; i < arr2.length; ++i) {
            for (int j = 0; j < arr1.length; ++j) {
                if (arr1[j] == arr2[i]) {
                    result[p++] = arr1[j];
                }
            }
        }
        for (int i = 0; i < arr1.length; ++i) {
            boolean flag = false;
            for (int j = 0; j < arr2.length; ++j) {
                if (arr1[i] == arr2[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                tmp[q++] = arr1[i];
            }
        }
        int[] tmp2 = new int[q];
        System.arraycopy(tmp, 0, tmp2, 0, q);
        quickSort(tmp2, 0, q - 1);
        System.arraycopy(tmp2, 0, result, result.length - q, q);
        return result;
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int begin, int end) {
        int counter = begin;
        int pivot = end;
        for (int i = begin; i < end; ++i) {
            if (arr[i] < arr[pivot]) {
                swap(arr, counter, i);
                counter++;
            }
        }
        swap(arr, counter, pivot);
        return counter;
    }

    private void swap(int[] arr, int i, int j) {
        int c = arr[i] ^ arr[j];
        arr[i] = c ^ arr[i];
        arr[j] = c ^ arr[j];
    }
}
