# Definition for singly-linked list (provided by LeetCode)
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummyHead = ListNode(0)
        tail = dummyHead
        carry = 0

        while l1 is not None or l2 is not None or carry != 0:
            digit1 = l1.val if l1 is not None else 0
            digit2 = l2.val if l2 is not None else 0

            sum = digit1 + digit2 + carry
            digit = sum % 10
            carry = sum // 10

            newNode = ListNode(digit)
            tail.next = newNode
            tail = tail.next

            l1 = l1.next if l1 is not None else None
            l2 = l2.next if l2 is not None else None

        result = dummyHead.next
        dummyHead.next = None
        return result
        
        # 'curr' is the pointer used to build the new list.
        curr = dummy
        
        # 'carry' tracks the carry-over to the next digit.
        carry = 0
        
        # Loop as long as there are nodes in either list OR there's a carry-over.
        while l1 or l2 or carry:
            
            # Get the value of the current node or 0 if the list is exhausted.
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            
            # 1. Sum the digits and the carry.
            total = val1 + val2 + carry
            
            # 2. Update the carry for the next iteration (e.g., 15 // 10 = 1).
            carry = total // 10
            
            # 3. Create a new node with the current digit (e.g., 15 % 10 = 5).
            # Attach it to the result list and move the 'curr' pointer.
            curr.next = ListNode(total % 10)
            curr = curr.next
            
            # 4. Advance the pointers for the next iteration.
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
                
        # The result is the next node after the dummy head.
        return dummy.next
        