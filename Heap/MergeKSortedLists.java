/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        
        // Heap
        // Time complexity: O(nlogk)     Space complexity: O(k)   (k is the number of lists)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(1, new Comparator<ListNode>(){
            @Override
            public int compare (ListNode l1, ListNode l2) {
                // See null element as biggest element
                if (l1 == null) {
                    return 1;
                }
                if (l2 == null) {
                    return -1;
                }
                return l1.val - l2.val;
            }
        });
        
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        while (!minHeap.isEmpty()) {
            ListNode list = minHeap.poll();
            
            p.next = list;
            p = list;
            
            if (list.next != null) {
                minHeap.offer(list.next);
            }
        }
        
        return dummyNode.next;
        
        
        /*
        // Divide and Conquer
        // Time complexity: O(nlogk)     Space complexity: O(k)
        return mergeList(lists, 0, lists.length - 1);
        */
    }
    
    private ListNode mergeList (ListNode[] lists, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return lists[i];
        }
        int mid = i + (j - i) / 2;
        ListNode leftList = mergeList(lists, i, mid);
        ListNode rightList = mergeList(lists, mid + 1, j);
        
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        
        while (leftList != null && rightList != null) {
            if (leftList.val < rightList.val) {
                p.next = leftList;
                leftList = leftList.next;
            } else {
                p.next = rightList;
                rightList = rightList.next;
            }
            p = p.next;
        }
        
        if (leftList != null) {
            p.next = leftList;
        }
        if (rightList != null) {
            p.next = rightList;
        }
        
        return dummyNode.next;
    }
}
