public class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (!map.containsKey(number)) {
	        list.add(number);
	    }
	    map.put(number, map.getOrDefault(number, 0) + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int num1 : list) {
	        int num2 = value - num1;
	        if (num1 != num2 && map.containsKey(num2) || num1 == num2 && map.get(num2) > 1) {
	            return true;
	        }
	    }
	    
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
