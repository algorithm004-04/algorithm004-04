package com.zhk.String;

import java.util.HashMap;

//leetcode 387. 字符串中的第一个唯一字符
public class FirstUniqChar {
    public int firstUniqChar(String s) {
            HashMap<Character, Integer> count = new HashMap<Character, Integer>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            for (int i = 0; i < n; i++) {
                if (count.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }
    }
