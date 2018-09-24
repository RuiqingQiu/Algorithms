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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        helper(root, 0, result);

        return result;
    }

    private void helper(TreeNode current, int level, List<Integer> result) {
        if (current == null) {
            return;
        }

        if (result.size() < level + 1) {
            result.add(current.val);
        } else {
            if (current.val > result.get(level)) {
                result.set(level, current.val);
            }
        }

        helper(current.left, level + 1, result);
        helper(current.right, level + 1, result);
    }
}
