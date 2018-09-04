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
    public TreeNode increasingBST(TreeNode root) {
        return helper(root, null);
    }

    private TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }

        TreeNode result = helper(root.left, root);

        root.left = null;

        root.right = helper(root.right, tail);

        return result;
    }
}
