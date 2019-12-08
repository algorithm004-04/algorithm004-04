package week_02.lesson5;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) {
            return ans;
        }
        Map<String,List<String>> result = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!result.containsKey(key)) {
                result.put(key,new ArrayList());
            }
            result.get(key).add(s);
        }
        ans.addAll(result.values());
        return ans;
    }

    public static void main(String[] args) {

    }

}
