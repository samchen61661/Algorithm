public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        
        ArrayList<ArrayList<Integer>> tmpRes = new ArrayList<>();
        List<Element> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new Element(building[0], -building[2]));
            list.add(new Element(building[1], building[2]));
        }
        Collections.sort(list, new Comparator<Element>(){
            @Override
            public int compare (Element e1, Element e2) {
                return (e1.index == e2.index) ? (e1.height - e2.height) : (e1.index - e2.index);
            }
        });
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(1, Collections.reverseOrder());
        
        heap.offer(0);
        int preVal = 0;
        for (Element element : list) {
            if (element.height < 0) {
                heap.offer(-element.height);
            } else {
                heap.remove(element.height);
            }
            
            if (preVal != heap.peek()) {
                ArrayList<Integer> outline = new ArrayList<>();
                outline.add(element.index);
                outline.add(heap.peek());
                tmpRes.add(outline);
                preVal = heap.peek();
            }
        }
        
        int preStart = tmpRes.get(0).get(0);
        int preHeight = tmpRes.get(0).get(1);
        
        for (int i = 1; i < tmpRes.size(); i++) {
            if (preHeight > 0) {
                ArrayList<Integer> outline = new ArrayList<>();
                outline.add(preStart);
                outline.add(tmpRes.get(i).get(0));
                outline.add(preHeight);
                res.add(outline);
            }
            preStart = tmpRes.get(i).get(0);
            preHeight = tmpRes.get(i).get(1);
            
        }
        
        return res;
    }
}

class Element {
    public int index;
    public int height;
    
    public Element (int index, int height) {
        this.index = index;
        this.height = height;
    }
}

