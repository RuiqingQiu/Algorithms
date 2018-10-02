/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int current = num1 + num2 + carry;

            if (current > 9) {
                current = current - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            tmp.next = new ListNode(current);
            tmp = tmp.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry == 1) {
            tmp.next = new ListNode(1);
        }

        return dummy.next;
    }
}
