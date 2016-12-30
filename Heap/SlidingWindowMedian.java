public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || k < 1 || nums.length < k) {
            return res;
        }
        
        MyHashHeap minHeap = new MyHashHeap("MIN");
        MyHashHeap maxHeap = new MyHashHeap("MAX");
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            minHeap.add(maxHeap.poll());
            
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            
            if (i >= k - 1) {
                int median = maxHeap.peek();
                res.add(median);
                
                if (nums[i + 1 - k] <= median) {
                    maxHeap.delete(nums[i + 1 - k]);
                } else {
                    minHeap.delete(nums[i + 1 - k]);
                }
            }
        } 
        
        return res;
    }
}

class MyHashHeap {
	private ArrayList<Integer> heap;
	private int size;
	private HashMap<Integer, Node> map;
	private String mode;
	
	class Node {
		public int pos;
		public int num;
		
		public Node (int pos, int num) {
			this.pos = pos;
			this.num = num;
		}
	}
	
	public MyHashHeap () {
		this("MIN");
	}
	
	public MyHashHeap (String mode) {
		heap = new ArrayList<>();
		size = 0;
		map = new HashMap<>();
		this.mode = mode;
	}
	
	public int peek () {
		return heap.get(0);
	}
	
	public int size () {
		return size;
	}
	
	public boolean isEmpty () {
		return (size == 0);
	}
	
	private int parent (int pos) {
		if (pos == 0) {
			return -1;
		}
		return (pos - 1) >>> 1;
	}
	
	private int leftSon (int pos) {
		return (pos << 1) + 1;
	}
	
	private int rightSon (int pos) {
		return (pos << 1) + 2;
	}
	
	private void swap (int pos1, int pos2) {
		int val1 = heap.get(pos1);
		int val2 = heap.get(pos2);
		
		int num1 = map.get(val1).num;
		int num2 = map.get(val2).num;
		
		map.put(val1, new Node(pos2, num1));
		map.put(val2, new Node(pos1, num2));
		
		heap.set(pos1, val2);
		heap.set(pos2, val1);
	}
	
	public int delete (int val) {
		size--;
		Node node = map.get(val);
		int num = node.num;
	    int pos = node.pos;

		if (num == 1) {
			swap(pos, heap.size() - 1);
			heap.remove(heap.size() - 1);
			map.remove(val);
			
			if (heap.size() > pos) {
                siftUp(pos);
                siftDown(pos);
            }
		} else {
			map.put(val, new Node(pos, num - 1));
		}
		
		return val;
	}
	
	public int poll () {
		return delete(heap.get(0));
	}
	
	public void add (int val) {
		size++;
		
		if (map.containsKey(val)) {
			Node node = map.get(val);
			map.put(val, new Node(node.pos, node.num + 1));
			
		} else {
			heap.add(val);
			map.put(val, new Node(heap.size() - 1, 1));
			siftUp(heap.size() - 1);
		}
		
	}
	
	private boolean compare (int val1, int val2) {
		if ("MIN".equals(mode)) {
			if (val1 < val2) {
				return true;
			} else {
				return false;
			}
			
		} else {
			if (val1 > val2) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private void siftUp (int pos) {
		int parentID = parent(pos);
		
		while (parentID > -1) {
			if (compare(heap.get(pos), heap.get(parentID))) {
				swap(pos, parentID);
			} else {
				break;
			}
		
			pos = parentID;
			parentID = parent(pos);
		} 
	}
	
	private void siftDown (int pos) {
		int size = heap.size();
		
		while (pos < size) {
			int tmp = pos;
			int leftSonID = leftSon(pos);
			int rightSonID = rightSon(pos);
			if (leftSonID < size && compare(heap.get(leftSonID), heap.get(pos))) {
				pos = leftSonID;
			}
			if (rightSonID < size && compare(heap.get(rightSonID), heap.get(pos))) {
				pos = rightSonID;
			}
			if (tmp == pos) {
				break;
			} else {
				swap(pos, tmp);
			}
		}
	}
}
