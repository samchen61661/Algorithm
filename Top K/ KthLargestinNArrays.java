public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        int entryLen = arrays.length;
        
        PriorityQueue<Element> queue = new PriorityQueue<Element>(entryLen, 
                new Comparator<Element>() {
            @Override
            public int compare (Element e1, Element e2) {
                return e2.val - e1.val;
            }
        }); 
        
        for (int i = 0; i < entryLen; ++i) {
            Arrays.sort(arrays[i]);   // length of 1D array is not determined   
            int len = arrays[i].length;
            if (len > 0) {
                queue.offer(new Element(arrays[i][len - 1], i, len - 1));
            }
        }
        
        while ((k - 1) > 0) {
            Element e = queue.poll();
            int col = e.col;
            if (col > 0) {
                int row = e.row;
                queue.offer(new Element(arrays[row][col - 1], row, col - 1));
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
}
