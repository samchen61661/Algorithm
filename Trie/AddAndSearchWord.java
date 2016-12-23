public class WordDictionary {
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper (String word, int index, TrieNode trieNode) {
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (char character : trieNode.children.keySet()) {
                    if (searchHelper(word, i + 1, trieNode.children.get(character))) {
                        return true;
                    }
                }
            }
            if (!trieNode.children.containsKey(c)) {
                return false;
            }
            trieNode = trieNode.children.get(c);
        }
        return trieNode.isWord == true;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

class TrieNode {
    public boolean isWord;
    public HashMap<Character, TrieNode> children;
        
    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}
