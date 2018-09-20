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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            current = current.right;
        }

        return result;
    }
}
