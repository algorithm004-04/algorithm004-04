package com.codertoy.week06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leecode_127_339 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 2;

        Set<String> meets = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>(Arrays.asList(beginWord));
        Set<String> endSet = new HashSet<>(Arrays.asList(endWord));
        return _search(1, beginSet, endSet, meets);
    }

    private int _search(int level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        if (beginSet.size() == 0 || endSet.size() == 0) return 0;
        meets.remove(beginSet);
        level++;
        Set<String> nextLeveSet = new HashSet<>();
        for (String beginWord : beginSet) {
            char[] chars = beginWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a'; ch < 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = String.valueOf(chars);
                    if (!meets.contains(newWord)) continue;
                    if (endSet.contains(newWord)) return level;
                    nextLeveSet.add(newWord);
                }
                chars[i] = temp;
            }
        }

        if (nextLeveSet.size() <= endSet.size()) {
            beginSet = nextLeveSet;
        } else {
            beginSet = endSet;
            endSet = nextLeveSet;
        }
        return _search(level, beginSet, endSet, meets);
    }
}
