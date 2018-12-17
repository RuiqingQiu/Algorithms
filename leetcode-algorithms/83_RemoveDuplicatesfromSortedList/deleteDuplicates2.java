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
            while (dummy.next.next != null && dummy.next.val == dummy.next.next.val) {
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }

        return tmp.next;
    }
}
