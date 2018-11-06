/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    PriorityQueue<Integer> pq;

    public int findSecondMinimumValue(TreeNode root) {
        pq = new PriorityQueue<Integer>(2, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        helper(root, pq);

        if (pq.size() < 2) {
            return -1;
        }

        return pq.peek();
    }

    public void helper(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) {
            return;
        }

        if (pq.size() == 2) {
            if (!pq.contains(root.val)) {
                if (root.val < pq.peek()) {
                    pq.poll();
                    pq.offer(root.val);
                }
            }
        } else {
            if (!pq.contains(root.val)) {
                pq.offer(root.val);
            }
        }

        helper(root.left, pq);
        helper(root.right, pq);
    }
}
