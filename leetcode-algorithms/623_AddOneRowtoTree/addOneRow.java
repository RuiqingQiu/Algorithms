/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode tmp = new TreeNode(v, root, null);
            return tmp;
        }
        helper(root, 1, v, d);
        return root;
    }

    public void helper(TreeNode root, int currentRow, int v, int d) {
        if (root == null) {
            return;
        }

        if (currentRow == d - 1) {
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            root.left = left;

            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.right = right;
            return;
        }
        helper(root.left, currentRow + 1, v, d);
        helper(root.right, currentRow + 1, v, d);
    }
}
