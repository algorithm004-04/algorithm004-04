class Solution {

    private Queue<Entry> queue = new ArrayDeque<>();
    private Set<String> visited = new HashSet<>();
    Map<String, List<String>> allDict = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (Objects.isNull(wordList) || wordList.size() == 0) {
            return 0;
        }

        // 预处理wordList，找出WordList中所有单词的所有通用状态，存入字典中
        getGeneralStatus(wordList);

        // 将单词列表放入队列中
        queue.offer(new Entry(beginWord, 1));
        while (true) {
            Entry entry = queue.poll();
            if (Objects.isNull(entry)) {
                return 0;
            } else if (entry.word.equals(endWord)) {
                System.out.println(entry.getWord());
                System.out.println("level: " + entry.getLevel());
                return entry.getLevel();
            } else if (visited.contains(entry.word)) {
                continue;
            }

            visited.add(entry.getWord());
            System.out.print(entry.getWord() + " -> ");
            findWordFromDict(entry.getWord(), entry.getLevel() + 1);
        }

    }

    private void getGeneralStatus(List<String> wordList) {

        wordList.forEach(word -> {
            transformStatus(word);
        });

    }

    private void transformStatus(String word) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            String status = word.substring(0, i) + '*' + word.substring(i + 1, len);
            List<String> words = allDict.get(status);
            if (Objects.isNull(words)) {
                words = new ArrayList<>();
                allDict.put(status, words);
            }
            words.add(word);
        }
    }


    private void findWordFromDict(String word, int level) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            String status = word.substring(0, i) + '*' + word.substring(i + 1, len);
            List<String> words = allDict.get(status);
            if (Objects.nonNull(words) && !words.isEmpty()) {
                words.forEach(w -> {
                    queue.offer(new Entry(w, level));
                });
            }
        }
    }


    class Entry {
        private String word;
        private int level;

        public Entry(String word, int level) {
            this.word = word;
            this.level = level;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}