package Tree;
//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//
//
// Note:
//
//
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
//
//
// Example 1:
//
//
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
//
//
// Example 2:
//
//
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
//
//
//
//
// Related Topics Breadth-first Search


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_127_334 {

    public static void main(String[] args) {
        String ss = "abc";
        System.out.println(ss.substring(0, 0));
        System.out.println(ss.substring(0, 2));
    }

    /**
     * 迭代
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthV1(String beginWord, String endWord, Set<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(beginWord);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            while (size > 0) {
                String word = queue.pollFirst();
                if (word.equals(endWord)) {
                    return steps;
                }
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (tmp == j) continue;
                        chars[i] = j;
                        String newStr = new String(chars);
                        if (set.contains(newStr)) {
                            queue.addLast(newStr);
                            set.remove(newStr);
                        }
                    }
                    chars[i] = tmp;
                }
                size--;
            }
        }
        return 0;
    }


    /**
     * 递归
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthV2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 2;

        Set<String> meets = new HashSet<>(wordList); // O(n)
        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        return this._search(1, beginSet, endSet, meets);
    }

    private int _search(int level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        if (beginSet.size() == 0 || endSet.size() == 0) return 0;
        meets.removeAll(beginSet);
        level++;
        Set<String> nextLevelSet = new HashSet<>();
        for (String beginWord : beginSet) {
            char[] chars = beginWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a'; ch < 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = String.valueOf(chars);
                    if (!meets.contains(newWord)) continue;
                    if (endSet.contains(newWord)) return level;
                    nextLevelSet.add(newWord);
                }
                chars[i] = temp;
            }
        }
        if (nextLevelSet.size() <= endSet.size()) {
            beginSet = nextLevelSet;
        } else {
            beginSet = endSet;
            endSet = nextLevelSet;
        }
        return this._search(level, beginSet, endSet, meets);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


