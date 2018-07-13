# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """

        def mergeTwoList(list1, list2):
            result = head = ListNode(0)

            while list1 and list2:
                if list1.val < list2.val:
                    result.next = list1
                    list1 = list1.next
                else:
                    result.next = list2
                    list2 = list2.next
                result = result.next
            if list1:
                result.next = list1
            elif list2:
                result.next = list2

            return head.next

        result = lists

        if len(result) == 0:
            return None

        while len(result) != 1:
            result.append(mergeTwoList(result.pop(), result.pop()))

        return result[0]
