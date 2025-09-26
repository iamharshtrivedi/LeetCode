/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 * var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        // Create a dummy head node for the result list.
        // This makes handling the head of the list much easier.
        val dummyHead = ListNode(0)
        var p1 = l1 // Pointer for the first list.
        var p2 = l2 // Pointer for the second list.
        var current = dummyHead // Pointer for the current node in the result list.
        var carry = 0 // Variable to store the carry-over digit.

        // Loop as long as there are nodes in either list or there's a carry.
        while (p1 != null || p2 != null || carry != 0) {
            // Get the value of the current node from l1, or 0 if null.
            val x = p1?.`val` ?: 0
            // Get the value of the current node from l2, or 0 if null.
            val y = p2?.`val` ?: 0

            // Calculate the sum of the digits and the carry.
            val sum = x + y + carry
            // Calculate the new carry.
            carry = sum / 10
            // Calculate the value of the new node (the last digit of the sum).
            val newNodeValue = sum % 10

            // Create a new node with the calculated value and attach it to the result list.
            current.next = ListNode(newNodeValue)
            // Move the current pointer to the newly created node.
            current = current.next!!

            // Move the pointers for the input lists to their next nodes, if they exist.
            if (p1 != null) {
                p1 = p1.next
            }
            if (p2 != null) {
                p2 = p2.next
            }
        }

        // Return the head of the result list. We skip the dummy node.
        return dummyHead.next
    }
}