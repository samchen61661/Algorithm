public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 
                || matrix[0].length == 0) {
            return 0;
        }
        final int[] deltaX = {0, 1};
        final int[] deltaY = {1, 0};
        PriorityQueue<Element> queue = new PriorityQueue<>(
                Math.min(k, matrix.length), new Comparator<Element>(){
            @Override
            public int compare (Element e1, Element e2) {
                return e1.val - e2.val;
            }
        });
        HashSet<Element> set = new HashSet<>();
        Element firstEle = new Element(matrix[0][0], 0, 0);
        queue.offer(firstEle);
        set.add(firstEle);
        
        while ((k - 1) > 0) {
            Element e = queue.poll();
            
            for (int i = 0; i < 2; ++i) {
                int x = e.row + deltaX[i];
                int y = e.col + deltaY[i];
                if (x < matrix.length && y < matrix[0].length) {
                    Element element = new Element(matrix[x][y], x, y);
                    if (set.add(element)) {
                        queue.offer(element);
                    }
                }
            }
            
            k--;
        }
            
        return queue.poll().val;
    }
}

class Element {
    public int val;
    public int row;
    public int col;
    public Element (int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
    
    @Override 
    public int hashCode () {
        int hash = 23;
        hash = hash * 31 + row;
        hash = hash * 31 + col;
        return hash;
    } 
    
    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Element e = (Element) o;
        return (row == e.row) && (col == e.col);
    }
}
