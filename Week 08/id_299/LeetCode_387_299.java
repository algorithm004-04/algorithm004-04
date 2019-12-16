package algorithm;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_387_299 {
    public static void main(String[] args) {
        LeetCode_387_299 firstUniqChar = new LeetCode_387_299();
        int i = firstUniqChar.firstUniqChar("leletcode");
        System.out.println("第一个不重复的字符串的索引:"+i);
    }
    public int firstUniqChar(String s) {
        long startTime = System.currentTimeMillis();
//        // 1.暴力
//        int len = s.length();
//        for(int i = 0;i<len;i++){
//            boolean isExist = true;
//            for(int j =0;j<len;j++) {
//                if( i == j){
//                    continue;
//                }
//                if (s.charAt(j) == s.charAt(i)) {
//                    isExist = false;
//                    break;
//                }
//            }
//            if(isExist){
//                System.out.println("耗时:"+(System.currentTimeMillis()-startTime)+"ms");
//                return i;
//            }
//        }
//        System.out.println("耗时:"+(System.currentTimeMillis()-startTime)+"ms");
//        return -1;
        //2. hash
//        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//        int len = s.length();
//        for (int i =0;i<len;i++){
//            char c = s.charAt(i);
//            if(map.containsKey(c)){
//                map.put(c,2); //不关心重复多少次
//            } else {
//                map.put(c,1); //只关心是否唯一
//            }
//        }
//        for (int i =0; i<len;i++){
//            char c = s.charAt(i);
//            if(map.containsKey(c) && map.get(c)==1){
//                System.out.println("耗时:"+(System.currentTimeMillis()-startTime)+"ms");
//                return i;
//            }
//        }
//
//        System.out.println("耗时:"+(System.currentTimeMillis()-startTime)+"ms");
//        return -1;

        //3. 桶
        int[] tong = new int[26]; // 26个桶装26个英文字母
        for (int i =0;i<s.length();i++){
            tong[s.charAt(i)-'a']++;
        }
        for (int i =0;i<s.length();i++){
            if(tong[s.charAt(i)-'a']==1){
                System.out.println("耗时:"+(System.currentTimeMillis()-startTime)+"ms");
                return i;
            }
        }
        System.out.println("耗时:"+(System.currentTimeMillis()-startTime)+"ms");
        return -1;
    }
}
