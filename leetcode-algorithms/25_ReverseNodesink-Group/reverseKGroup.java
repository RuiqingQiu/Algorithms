/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;

        while (current != null && count != k) {
            current = current.next;
            count += 1;
        }

        if (count == k) {
            current = reverseKGroup(current, k);

            while (count > 0) {
                ListNode tmp = head.next;
                head.next = current;
                current = head;
                head = tmp;
                count -= 1;
            }

            head = current;
        }

        return head;
    }
}
