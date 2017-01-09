public class ZigzagIterator {
    /**
     * @param v1 v2 two 1d vectors
     */
     
    private Iterator<Integer> iter1;
    private Iterator<Integer> iter2;
    private Iterator<Integer> tmp;
     
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter1 = v1.iterator();
        iter2 = v2.iterator();
    }

    public int next() {
        if (iter1.hasNext()) {
            tmp = iter1;
            iter1 = iter2;
            iter2 = tmp;
        }
        
        return iter2.next();
    }

    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext();  
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
