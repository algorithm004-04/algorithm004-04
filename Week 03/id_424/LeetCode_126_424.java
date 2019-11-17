package com.wangyao.Word_Ladder_Ⅱ;

import java.util.*;

/**
 * @Author: Ori
 * @Time: 2019/11/1
 */
public class Practice_2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord))
            return ans;

        //保持beginWord到每个结点的距离
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map, distance);
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, temp, ans, map, distance);
        return ans;
    }

    private void findLaddersHelper(String beginWord, String endWord,
                                   List<String> temp,
                                   List<List<String>> ans,
                                   HashMap<String, ArrayList<String>> map,
                                   HashMap<String, Integer> distance) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        ArrayList<String> neighbors = map.getOrDefault(beginWord,
                new ArrayList<>());
        for (String neighbor : neighbors) {
            if (distance.get(beginWord) + 1 == distance.get(neighbor)) {
                temp.add(neighbor);
                findLaddersHelper(neighbor, endWord, temp, ans, map, distance);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        int dept = 0;
        boolean isFound = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            dept++;
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                ArrayList<String> neighbors = getNeighbors(temp, wordList);
                map.put(temp, neighbors);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, dept);
                        if (neighbor.equals(endWord))
                            isFound = true;
                        queue.offer(neighbor);
                    }
                }
            }
            if (isFound) break;
        }
    }

    private ArrayList<String> getNeighbors(String temp, List<String> wordList) {
        ArrayList<String> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordList);

        char[] ch = temp.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < temp.length(); i++) {
                char old = ch[i];
                if (ch[i] == c)
                    continue;
                ch[i] = c;
                String newWord = String.valueOf(ch);
                if (dict.contains(newWord))
                    res.add(newWord);
                ch[i] = old;
            }
        }
        return res;
    }
}
