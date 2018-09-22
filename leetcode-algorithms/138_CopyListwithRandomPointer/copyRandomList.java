/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // 1st iteration, attach copy node next to original node
        if (head == null) {
            return null;
        }

        RandomListNode dummy = head;
        RandomListNode current = head;

        // 1st iteration Copy
        while (current != null) {
            RandomListNode copy = new RandomListNode(current.label);

            RandomListNode next = current.next;
            current.next = copy;
            copy.next = next;

            current = current.next.next;
        }

        // 2nd iteration Random Pointer
        RandomListNode result = head.next;
        current = head;

        while (current != null) {
            RandomListNode copy = current.next;

            if (current.random != null)
                copy.random = current.random.next;
            current = current.next.next;
        }

        // 3rd iteration restore original and copy list
        current = head;
        while (current != null) {
            RandomListNode copy = current.next;
            current.next = copy.next;
            current = current.next;

            if (current != null)
                copy.next = current.next;
        }

        return result;

    }
}
