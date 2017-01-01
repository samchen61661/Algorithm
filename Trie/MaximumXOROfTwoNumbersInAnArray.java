public class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        Trie trie = new Trie();
        int max = Integer.MIN_VALUE;
        
        for (int num : nums) {
            trie.add(num);
        } 
        
        for (int num : nums) {
            TrieNode tmp = trie.root;
            int val = 0;
            // The least significant bit should be leaves in the trie. 
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                // We want to add 1 to the result if possible.
                if (tmp.children[bit ^ 1] != null) {
                    val |= (1 << i);
                    tmp = tmp.children[bit ^ 1];
                } else {
                    tmp = tmp.children[bit];
                }
            }
            max = Math.max(max, val);
        }
        
        return max;
    }
}

class TrieNode {
    public TrieNode[] children;
    
    public TrieNode () {
        children = new TrieNode[2];
    }
}

class Trie {
    public TrieNode root;
    
    public Trie () {
        root = new TrieNode();
    }
    
    public void add (int num) {
        TrieNode tmp = root;
        // The least significant bit should be leaves in the trie. 
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (tmp.children[bit] == null) {
                tmp.children[bit] = new TrieNode();
            }
            tmp = tmp.children[bit];
        }
    }
}
