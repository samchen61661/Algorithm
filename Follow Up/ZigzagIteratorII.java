public class ZigzagIterator2 {
    /**
     * @param vecs a list of 1d vectors
     */
    private List<Iterator<Integer>> list;
    private int num;
    
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        list = new LinkedList<>();
        num = 0;
        
        for (ArrayList<Integer> vec : vecs) {
            if (vec.size() > 0) {
                list.add(vec.iterator());
            }
        }
    }

    public int next() {
        int val = list.get(num).next();
        
        if (list.get(num).hasNext()) {
            num = (++num) % list.size();
            
        } else {
            list.remove(num);
            
            // avoid ArithmeticException
            if (list.size() > 0) {
                num %= list.size();
            }
        }
        return val;
    }

    public boolean hasNext() {
        return list.size() > 0;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
