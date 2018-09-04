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
        List<TreeNode> inorder = new ArrayList<TreeNode>();

        helper(inorder, root);
        TreeNode result = inorder.get(0);
        TreeNode dummy = result;
        dummy.left = null;
        dummy.right = null;

        for (int i = 1; i < inorder.size(); i++) {
            dummy.right = inorder.get(i);
            dummy = dummy.right;
            dummy.left = null;
        }

        return result;
    }

    private void helper(List<TreeNode> inorder, TreeNode root) {
        if (root == null) {
            return;
        }

        helper(inorder, root.left);
        inorder.add(root);
        helper(inorder, root.right);
    }
}
