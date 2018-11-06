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
    int min;
    int secondMin = Integer.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root != null) {
            if (root.val > min && root.val < secondMin) {
                secondMin = root.val;
            } else if (root.val == min) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;

        dfs(root);

        return secondMin < Integer.MAX_VALUE ? secondMin : -1;
    }
}
