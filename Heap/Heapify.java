public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if (A == null) {
            return;
        }
        int len = A.length;
        
        /*
        // Time complexity: O(n)
        for (int i = len / 2; i >= 0; --i) {
            siftDown(A, i);
        }
        */
        
        // Time complexity: O(nlogn)
        for (int i = 1; i < len; i++) {
            siftUp(A, i);
        }
    }
    
    private void siftUp (int[] A, int i) {
        while (i != 0) {
            int parent = (i - 1) / 2;
            
            if (A[parent] <= A[i]) {
                break;
            }
            swap(A, i, parent);
            i = parent;
        }
    }
    
    private void siftDown (int[] A, int i) {
        int len = A.length;
        
        while (i < len) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int tmp = i;
            
            // Select the smaller value of children to swap values 
            if ((leftChild < len) && A[leftChild] < A[i]) {
                i = leftChild;
            } 
            if ((rightChild < len) && A[rightChild] < A[i]) {
                i = rightChild;
            }
            
            if (i == leftChild || i == rightChild) {
                swap(A, i, tmp);
            } else {
                break;
            }
        }
    }
    
    private void swap (int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
