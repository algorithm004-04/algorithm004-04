package week_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49_234 {
  // 思路:排序取key 根据key分组
  // 哈希法 T:O(nKlog(K)) 循环*排序, S:O(nK)
  public static List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> hash = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      // 排序 让str统一
      char[] c_arr = strs[i].toCharArray();
      Arrays.sort(c_arr);
      String key = String.valueOf(c_arr);
      // 检查是否有key存在 有add ,无new arr然后add
      if (hash.containsKey(key)) {
        hash.get(key).add(strs[i]);
      } else {
        List<String> temp = new ArrayList<>();
        temp.add(strs[i]);
        hash.put(key, temp);
      }
    }

    return new ArrayList<>(hash.values());
  }
}
