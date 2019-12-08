package week_07;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1122_234 {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] counter = new int[1001];
    int[] result = new int[arr1.length];
    // 计数
    for (int i = 0; i < arr1.length; i++) {
      int number_at_counter = arr1[i];
      counter[number_at_counter]++;
    }
    int index_at_result = 0;
    for (int i = 0; i < arr2.length; i++) {
      int number_at_counter = arr2[i];
      while (counter[number_at_counter] > 0) {
        result[index_at_result] = number_at_counter;
        index_at_result++;
        counter[number_at_counter]--;
      }
    }
    for (int i = 0; i < counter.length; i++) {
      while (counter[i] > 0) {
        result[index_at_result] = i;
        index_at_result++;
        counter[i]--;
      }
    }

    return result;
  }
}
