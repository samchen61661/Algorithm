public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     
    private int[] deltaX = {1, 0, -1, 0};
    private int[] deltaY = {0, 1, 0, -1};
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> res = new ArrayList<>();
        if (board == null || words == null || words.size() == 0) {
            return res;
        }
        int row = board.length;
        if (row == 0) {
            return res;
        }
        int col = board[0].length;
        if (col == 0) {
            return res;
        }
        
        Trie trie = new Trie();
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            trie.insert(word);
        }
        
        boolean[][] isVisited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(res, board, i, j, trie, new StringBuilder(), set, isVisited);
            }
        }
        
        return res;
    }
    
    private void dfs (List<String> res, char[][] board, int i, int j, Trie trie, StringBuilder builder, HashSet<String> set, boolean[][] isVisited) {
        int row = board.length;
        int col = board[0].length;
        
        if (i >= 0 && j >= 0 && i < row && j < col && !isVisited[i][j]) {
            builder.append(board[i][j]);
            isVisited[i][j] = true;
            
            if (trie.startsWith(builder.toString())) {
                if (trie.search(builder.toString()) && set.add(builder.toString())) {
                    res.add(builder.toString());
                }
                
                for (int k = 0; k < 4; k++) {
                    int new_x = i + deltaX[k];
                    int new_y = j + deltaY[k];
                    dfs(res, board, new_x, new_y, trie, builder, set, isVisited);    
                }
            }
    
            isVisited[i][j] = false;
            builder.setLength(builder.length() - 1);
        }
    }
}

class TrieNode {
    public boolean isWord;
    public HashMap<Character, TrieNode> children;
        
    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}

class Trie {
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
