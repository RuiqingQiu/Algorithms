/**
 *  public class ListNode {
 *    int val;
 *    ListNode next;
 *    ListNode(int x) {val = x;}
 * }
 * merge k sorted list into one sorted list
 **/
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy_head = new ListNode(-1);
    ListNode current = dummy_head;
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
      public int compare(ListNode a, ListNode b) {
        return a.val.compareTo(b.val);
      }
    });
    for (int i = 0; i < lists.length; i++) {
      pq.add(lists[0]);
    }

    while (!pq.isEmpty()) {
      current.next = pq.poll();
      current = current.next;
      if (current.next != null) {
        pq.add(current.next);
      }
    }
    return dummy_head.next;
  }
}
