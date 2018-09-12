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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(root, result, 0);

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(result.get(i));
            }
        }

        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }

        result.get(level).add(root.val);
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
