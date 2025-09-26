/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * Time Complexity: O(max(N, M)), where N and M are the lengths of l1 and l2.
     * We iterate through both lists exactly once.
     *
     * Space Complexity: O(max(N, M)), as we create a new linked list to store the sum.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. Initialize a dummy node. This is the simplest way to handle the head of the new list.
        ListNode dummyHead = new ListNode(0);
        
        // 'current' pointer to build the new list.
        ListNode current = dummyHead; 
        
        // 'carry' tracks the carry-over from the previous digit addition.
        int carry = 0; 

        // 2. Loop until both lists are exhausted AND there is no carry.
        while (l1 != null || l2 != null || carry != 0) {
            
            // Get digit from l1 (or 0 if l1 is null).
            int x = (l1 != null) ? l1.val : 0;
            
            // Get digit from l2 (or 0 if l2 is null).
            int y = (l2 != null) ? l2.val : 0;

            // 3. Perform the addition (current digits + carry).
            int sum = x + y + carry;

            // Calculate the new carry for the next iteration.
            carry = sum / 10;
            
            // Calculate the digit for the current node.
            int digit = sum % 10;

            // 4. Create a new node and append it to the result list.
            current.next = new ListNode(digit);
            
            // Move the current pointer forward.
            current = current.next;

            // 5. Advance the list pointers.
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 6. Return the actual head of the list (the node after the dummy head).
        return dummyHead.next;
    }
}