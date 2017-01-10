class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> res = new ArrayList<>();
        
        if (A == null || A.length == 0 || A[0].length == 0) {
            return res;    
        }
        
        /*
        // Binary Search 
        // Time Complexity: O(nlogn)
        int col = A[0].length;
        int left = 1;
        int right = col - 2;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            Element maxElement = findMaxVertical(A, mid);
            int maxVal = maxElement.val;
            int index = maxElement.row;
            
            if(A[index][mid - 1] > maxVal) {
                right = mid;
            } else if (A[index][mid + 1] > maxVal) {
                left = mid;
            } else {
                res.add(index);
                res.add(mid);
                return res;
            }
        }
        
        Element maxElement = findMaxVertical(A, left);
        int maxVal = maxElement.val;
        int index = maxElement.row;
        
        if (maxVal > A[index][left - 1] 
                && maxVal > A[index][left + 1]) {
            res.add(index);
            res.add(left);
            return res;
        }
        
        maxElement = findMaxVertical(A, right);
        index = maxElement.row;
        
        res.add(index);
        res.add(right);
        return res;
        */
        

        // Binary Search 
        // Time Complexity: O(n)
        int row = A.length;
        int col = A[0].length;
        int up = 1;
        int down = row - 2;
        int left = 1;
        int right = col - 2;
        boolean isVertical = true;
        
        while (up + 1 < down && left + 1 < right) {
            // scan max element in horizontal direction
            if (!isVertical) {
                int mid = up + (down - up) / 2;
                
                Element maxElement = findMaxHorizontal(A, mid);
                int maxVal = maxElement.val;
                int index = maxElement.col;
                
                if(A[mid - 1][index] > maxVal) {
                    down = mid;
                    
                } else if (A[mid + 1][index] > maxVal) {
                    up = mid;
                    
                } else {
                    res.add(mid);
                    res.add(index);
                    return res;
                }
                
                isVertical = false;
                
            // scan max element in vertical direction
            } else {
                int mid = left + (right - left) / 2;
                
                Element maxElement = findMaxVertical(A, mid);
                int maxVal = maxElement.val;
                int index = maxElement.row;
                
                if(A[index][mid - 1] > maxVal) {
                    right = mid;
                    
                } else if (A[index][mid + 1] > maxVal) {
                    left = mid;
                    
                } else {
                    res.add(index);
                    res.add(mid);
                    return res;
                }
                
                isVertical = true;
            }    
        }
        
        if (up + 1 > down) {
            Element maxElement = findMaxHorizontal(A, up);
            int maxVal = maxElement.val;
            int index = maxElement.col;
        
            if (maxVal > A[up - 1][index] && maxVal > A[up + 1][index]) {
                res.add(up);
                res.add(index);
                return res;
            }
            
            maxElement = findMaxHorizontal(A, down);
            index = maxElement.col;
        
            res.add(down);
            res.add(index);
            return res;
            
        } else {
            Element maxElement = findMaxVertical(A, left);
            int maxVal = maxElement.val;
            int index = maxElement.row;
        
            if (maxVal > A[index][left - 1] 
                    && maxVal > A[index][left + 1]) {
                res.add(index);
                res.add(left);
                return res;
            }
        
            maxElement = findMaxVertical(A, right);
            index = maxElement.row;
        
            res.add(index);
            res.add(right);
            return res;
        }
        
    }
    
    private Element findMaxVertical (int[][] A, int col) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        int row = A.length;
        
        for (int i = 0; i < row; i++) {
            if (max <= A[i][col]) {
                max = A[i][col];
                index = i;
            }
        }
        
        return new Element(index, col, A[index][col]);
    }
    
    private Element findMaxHorizontal (int[][] A, int row) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        int col = A[0].length;
        
        for (int i = 0; i < col; i++) {
            if (max <= A[row][i]) {
                max = A[row][i];
                index = i;
            }
        }
        
        return new Element(row, index, A[row][index]);
    }
}

class Element {
    public int row;
    public int col;
    public int val;
    
    public Element (int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
