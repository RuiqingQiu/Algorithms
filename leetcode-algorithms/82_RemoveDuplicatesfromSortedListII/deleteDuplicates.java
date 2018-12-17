/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        dummy.next = head;

        while (dummy.next != null) {
            ListNode current = dummy.next;

            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                    dummy.next = current.next;
                }
            } else {
                dummy = dummy.next;
            }
        }

        return tmp.next;
    }
}
