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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, root);
        
        return result;
    }

    private int helper(List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = helper(result, root.left);
        int right = helper(result, root.right);

        int currentLevel = Math.max(left, right) + 1;

        if (result.size() <= currentLevel) {
            result.add(new ArrayList<Integer>());
        }

        result.get(currentLevel).add(root.val);

        return currentLevel;
    }
}
