public class Solution {
    public boolean firstWillWin(int n) {
        if (n < 0) {
            return false;
        }
        
        boolean[] memo = new boolean[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        
        return search(n, memo, isVisited);  
    }
    
    private boolean search (int n , boolean[] memo, boolean[] isVisited) {
        if (isVisited[n]) {
            return memo[n];
        }
        
        if (n <= 0) {
            return false;
            
        } else if (n == 1) {
            return true;
            
        } else if (n == 2) {
            return true;
            
        } else {
            // Version 1: from the aspect of current player (stack overflow)
            //memo[n] = !search(n - 1, memo, isVisited) 
            //        || !search(n - 2, memo, isVisited);
            
            // Version 2: from the aspect of first player
            memo[n] = search(n - 2, memo, isVisited) 
                    && search(n - 3, memo, isVisited) 
                    || search(n - 3, memo, isVisited) 
                    && search(n - 4, memo, isVisited);  
        }
        
        // flag true after setting memo array
        isVisited[n] = true;
        return memo[n];
    }
}


