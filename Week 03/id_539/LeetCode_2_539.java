class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();

        if(!wordSet.contains(endWord)){
            return 0;
        }

        int resultLength = 1;
        int beginWordLength = beginWord.length();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //保证把尺寸更小的集合作为开始集合，遍历起点
            if (beginSet.size() > endSet.size()) {
                Set<String> tempSet = endSet;
                endSet = beginSet;
                beginSet = tempSet;
            }

            Set<String> tmpBeginSet = new HashSet<>();
            //从beginSet开始检查其中的每个单词
            for (String word : beginSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    for (char c = 'a'; c <= 'z'; c++) {
                        char prevChar = chars[i];
                        chars[i] = c;
                        String target = String.valueOf(chars);
                        if (endSet.contains(target)) {
                            return resultLength + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            tmpBeginSet.add(target);
                            visited.add(target);
                        }
                        chars[i] = prevChar;
                    }
                }
            }

            beginSet = tmpBeginSet;
            resultLength++;
        }

        return 0;
    }
}