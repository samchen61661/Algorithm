/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null) {
            return;
        }
        int lenN = nuts.length;
        int lenB = bolts.length;
        
        if (lenN != lenB) {
            return;
        }
        quickSelection(nuts, bolts, 0, lenN - 1, compare);
    }
    
    private void quickSelection (String[] nuts, String[] bolts, int left, int right, NBComparator compare) {
        if (left >= right) {
            return;
        }
        
        int position = partition(nuts, bolts[left], left, right, compare);
        partition(bolts, nuts[position], left, right, compare);
        
        quickSelection(nuts, bolts, left, position - 1, compare);
        quickSelection(nuts, bolts, position + 1, right, compare);
    }
    
    private int partition (String[] strs, String pivot, int l, int r, NBComparator compare) {
        for (int i = l; i <= r; i++) {
            if (compare.cmp(strs[i], pivot) == 0 
                    || compare.cmp(pivot, strs[i]) == 0) {
                swap(strs, l, i);
                break;
            }
        }
        
        String strsPivot = strs[l];
        int left = l;
        int right = r;
        
        while (left < right) {
            while (left < right && (compare.cmp(strs[right], pivot) == 1 
                    || compare.cmp(pivot, strs[right]) == -1)) {
                right--;
            }
            strs[left] = strs[right];
            
            while (left < right && (compare.cmp(strs[left], pivot) == -1 
                    || compare.cmp(pivot, strs[left]) == 1)) {
                left++;
            }
            strs[right] = strs[left];
            
        }
        
        strs[left] = strsPivot;
        return left;
        
    }
    
    private void swap (String[] s, int i, int j) {
        String tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
};
