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
    int max = 0;
    
    public int maxDepth(TreeNode root) {
        helper(root, 1);

        return max;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        max = Math.max(depth, max);

        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
