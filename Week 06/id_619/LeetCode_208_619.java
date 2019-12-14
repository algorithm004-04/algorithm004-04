class Trie {
    
   
    
    /** Initialize your data structure here. */
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i=0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!node.containsKey(curChar)) {
                node.put(curChar, new TrieNode());
            }
            node = node.get(curChar);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null&&node.isEnd();
    }
    
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
          for (int i=0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (node.containsKey(curChar)) {
                node = node.get(curChar);
            }else {
                return null;
            }
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }
}

 class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[R];
        }
        
        public boolean containsKey(char ch) {
            return links[ch-'a'] != null;
        }
        
        public TrieNode get(char ch) {
            return links[ch-'a'];
        }
        
        public void put(char ch, TrieNode node) {
            links[ch-'a'] = node;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
}