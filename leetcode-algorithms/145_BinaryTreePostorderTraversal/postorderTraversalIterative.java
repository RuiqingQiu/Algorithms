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
    public List<Integer> postorderTraversal(TreeNode root) {
        // Idea is to use modified preorder into root right left and then reverse to
        // get postorder left right root
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                result.addFirst(current.val);

                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            current = current.left;
        }


        return result;
    }
}
