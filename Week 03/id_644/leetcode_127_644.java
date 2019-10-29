package week03;

import java.util.*;

public class wordlader {
    public static void main(String[] args) {
        String beginword = "hit";
        String endword = "cog";
        String[] temp = {"hot","dot","dog","lot","log","cog"};
        List<String> wordlist = new ArrayList<String>(Arrays.asList(temp));

        System.out.println(ladderLength(beginword,endword,wordlist));

    }//
    ///感觉自己写不出来
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur = q.poll();
                for (int i = 0; i < endWord.length(); i++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder newWord = new StringBuilder(cur);
                        newWord.setCharAt(i, letter);
                        if (set.contains(newWord.toString())) {
                            if (newWord.toString().equals(endWord)) return step + 1;
                            set.remove(newWord.toString());
                            q.offer(newWord.toString());
                        }
                    }
                }

            }
            step++;
        }
        return 0;
    }
}



