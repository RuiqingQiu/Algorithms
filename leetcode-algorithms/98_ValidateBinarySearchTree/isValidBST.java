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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode current, long min, long max) {
        if (current == null) {
            return true;
        }

        if (current.val <= min || current.val >= max) {
            return false;
        }

        return helper(current.left, min, current.val) && helper(current.right, current.val, max);
    }
}
