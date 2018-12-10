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
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode child = root.val < target ? root.right : root.left;

        if (child == null) {
            return a;
        }

        int b = closestValue(child, target);

        return Math.abs(a - target) > Math.abs(b - target) ? b : a;
    }
}
