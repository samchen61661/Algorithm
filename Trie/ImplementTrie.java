/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    public boolean isWord;
    public HashMap<Character, TrieNode> children;
        
    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) {
            return;
        }
        
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            if (!tmp.children.containsKey(c)) {
                TrieNode node = new TrieNode();
                tmp.children.put(c, node);
            }
            tmp = tmp.children.get(c);
        }
        tmp.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            if (!tmp.children.containsKey(c)) {
                return false;
            }
            tmp = tmp.children.get(c);
        }
        return tmp.isWord == true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        
        TrieNode tmp = root;
        for (char c : prefix.toCharArray()) {
            if (!tmp.children.containsKey(c)) {
                return false;
            }
            tmp = tmp.children.get(c);
        }
        return true;
    }
}
