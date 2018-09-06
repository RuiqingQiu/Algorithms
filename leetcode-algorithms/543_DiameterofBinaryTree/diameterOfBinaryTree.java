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
    int max = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);

        return max - 1;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max, 1 + left + right);

        return 1 + Math.max(left, right);
    }
}
