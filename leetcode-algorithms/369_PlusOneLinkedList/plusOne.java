/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (helper(head) == 1) {
            ListNode tmp = new ListNode(1);
            tmp.next = head;

            return tmp;
        }

        return head;
    }

    public int helper(ListNode head) {
        if (head == null) {
            return 1;
        }

        if (helper(head.next) == 1) {
            int current = head.val + 1;

            if (current > 9) {
                head.val = current - 10;
                return 1;
            } else {
                head.val = current;
                return 0;
            }
        } else {
            return 0;
        }
    }
}
