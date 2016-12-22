public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if (A == null || A.length == 0 
                || B == null || B.length == 0) {
            return 0;
        } 
        
        PriorityQueue<Element> queue = new PriorityQueue<>(A.length, 
                new Comparator<Element>(){
            @Override
            public int compare (Element e1, Element e2) {
                return e1.val - e2.val;
            }
        });
        
        for (int i = 0; i < A.length; i++) {
            queue.offer(new Element(A[i] + B[0], i, 0));
        }
        
        while ((k - 1) > 0) {
            Element e = queue.poll();
            int indexA = e.indexA;
            int indexB = e.indexB;
            if (indexB < (B.length - 1)) {
                queue.offer(new Element(A[indexA] + B[indexB + 1], 
                        indexA, indexB + 1));
            }
            
            k--;
        }
        
        return queue.poll().val;
    }
}

class Element {
    public int val;
    public int indexA;
    public int indexB;
    
    public Element (int val, int indexA, int indexB) {
        this.val = val;
        this.indexA = indexA;
        this.indexB = indexB;
    }
}
