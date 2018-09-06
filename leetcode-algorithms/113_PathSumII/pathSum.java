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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        helper(root, sum, new ArrayList<Integer>(), result);

        return result;
    }

    private void helper(TreeNode root, int remain, List<Integer> lst, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        lst.add(root.val);

        if (root.left == null && root.right == null && remain - root.val == 0) {
            result.add(new ArrayList(lst));
        } else {
            helper(root.left, remain - root.val, lst, result);

            helper(root.right, remain - root.val, lst, result);
        }

        lst.remove(lst.size() - 1);
    }
}
