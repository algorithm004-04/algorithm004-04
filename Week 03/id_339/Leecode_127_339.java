package com.codertoy.week03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leecode_127_339 {
    // 双端BFS，同时根据以少到多的方法提升程序性能
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 2;

        Set<String> meets = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>(Arrays.asList(beginWord));
        Set<String> endSet = new HashSet<>(Arrays.asList(endWord));

        return _search(1, beginSet, endSet, meets);
    }

    private Integer _search(Integer level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        // terminator
        if (beginSet.size() == 0 || endSet.size() == 0) return 0;

        // process
        // 移除原始单词，避免单词字符替换时重复问题
        meets.removeAll(beginSet);
        level++;
        // 用于临时存放下一层的beginSet或者endSet
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

        // drill down
        // 总是从少到多
        if (nextLevelSet.size() <= endSet.size()) {
            beginSet = nextLevelSet;
        } else {
            beginSet = endSet;
            endSet = nextLevelSet;
        }
        return _search(level, beginSet, endSet, meets);
    }
}
