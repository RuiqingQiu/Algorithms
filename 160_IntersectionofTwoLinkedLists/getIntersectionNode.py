# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        lenA = 0
        lenB = 0

        pa = headA
        pb = headB

        while pa:
            lenA += 1
            pa = pa.next

        while pb:
            lenB += 1
            pb = pb.next

        pa = headA
        pb = headB
        if lenA > lenB:
            diff = lenA - lenB

            while diff > 0:
                diff -= 1
                pa = pa.next
        elif lenB > lenA:
            diff = lenB - lenA

            while diff > 0:
                diff -= 1
                pb = pb.next

        while pa and pb:
            if pa == pb:
                return pa
            else:
                pa = pa.next
                pb = pb.next

        return None
