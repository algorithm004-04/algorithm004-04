package week03;

//单词接龙
//输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//返回它的长度 5。


import common.TreeNode;
import common.Utils;

import java.util.*;


public class LeetCode127_294 {

    Map<String, Boolean> all = new HashMap<String, Boolean>();
    Queue<String> checkList = new LinkedList<String>();

    /**
     * 思路:
     * 对checkList中的单词逐个字母替换，检查剩余单词里有没有替换后的单词，有的话即为下一层节点。
     *
     * 86ms
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        int step = 1;
        checkList.add(beginWord);
        all.put(endWord, true);
        for (String word : wordList) {
            all.put(word, true);
        }
        while (checkList.size() > 0) {
            int size = checkList.size();
            for (int k=0;k<size;k++) {
                String str = checkList.poll();
                if (str.equals(endWord)) {
                    return step + 1;
                }

                for (int i=0; i<str.length(); i++) {
                    char[] strArr = str.toCharArray();
                    for (char s = 'a'; s <= 'z'; s ++) {
                        strArr[i] = s;
                        String newStr = new String(strArr);
                        if (all.containsKey(newStr)) {
                            if (newStr.equals(endWord)) {
                                return step + 1;
                            }
                            checkList.add(newStr);
                            all.remove(newStr);
                        }
                    }
                }
            }
            if (checkList.size() == 0) {
                return 0;
            }
            step ++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] all = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> list = new ArrayList<String>();
        for (String str : all ) {
            list.add(str);
        }
        int step = new LeetCode127_294().ladderLength("hit", "cog", list);
        System.out.println(step);
    }
}
