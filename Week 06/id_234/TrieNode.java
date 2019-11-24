package weak_06;

public class TrieNode {

    // R links to node children
    private String nodeValue;

    public String getNodeValue() {
        return String.valueOf(nodeValue) ;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;


    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
