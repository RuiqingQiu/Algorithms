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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();

        if (root == null) {
            return result;
        }

        helper(result, root, "" + root.val);

        return result;
    }

    private void helper(List<String> result, TreeNode root, String current) {
        // left node
        if (root.left == null && root.right == null) {
            result.add(current);
            return;
        }

        if (root.left != null) {
            helper(result, root.left, current + "->" + root.left.val);
        }

        if (root.right != null) {
            helper(result, root.right, current + "->" + root.right.val);
        }
    }
}
