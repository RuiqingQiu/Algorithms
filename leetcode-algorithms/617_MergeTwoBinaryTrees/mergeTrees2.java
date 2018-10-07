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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        int val1 = t1 == null ? 0 : t1.val;
        int val2 = t2 == null ? 0 : t2.val;
        TreeNode result = new TreeNode(val1 + val2);

        TreeNode left = t1 == null ? null : t1.left;
        TreeNode left2 = t2 == null ? null : t2.left;

        result.left = mergeTrees(left, left2);

        TreeNode right = t1 == null ? null : t1.right;
        TreeNode right2 = t2 == null ? null : t2.right;

        result.right = mergeTrees(right, right2);

        return result;
    }
}
