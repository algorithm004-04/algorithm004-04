import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (55.72%)
 * Likes:    116
 * Dislikes: 0
 * Total Accepted:    51.5K
 * Total Submissions: 91.4K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start

//暴力 ，将两个字符串排序，如果排序后的byte[]相同，则返回true
class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        byte[] b1 = s.getBytes();
        byte[] b2 = t.getBytes();
        Arrays.sort(b1);
        Arrays.sort(b2);


        return Arrays.equals(b1, b2);

    }
}

//用数组存储每个字母出现的频次。a-z分别对应下标为0-25
class Solution2 {
    public boolean isAnagram(String s, String t) {

        int[] nums = new int[26]; //26个英文字母，记入出现的次数
        
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            nums[t.charAt(i)-'a']--;
        }

        

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 )  return false;
        }

        return true;
    }
}

//将Solution2减少了一次循环，但在leetcode上的执行速度不比Solution2快
//可能是增加了第一行的判断。且样例中的字符串长度不大。
class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] nums = new int[26]; //26个英文字母，记入出现的次数
        
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)-'a']++;
            nums[t.charAt(i)-'a']--;
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 )  return false;
        }

        return true;
    }
}
//对Solution2做的另一个改进。
class Solution4 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            //因为s与t长度相等，如果有字母不一样，一定会出现小于0的情况
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
//如果字符串中包含unicode字符，则将字符和频次当做<key,value>存储到map中
class Solution5 {
    public boolean isAnagram(String s, String t) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < s.length(); i++) {
            int key  = s.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key,1);
            }else {
                int value = map.get(key);
                map.put(key,value+1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            int key  = t.charAt(i);
            if (map.containsKey(key)) {
                int value = map.get(key);
                if (value == 1 )
                    map.remove(key);
                else 
                    map.put(key,value-1);    
            }else{
                return false;
            }

            
        }
        
        return map.isEmpty();
    }
}

// @lc code=end
