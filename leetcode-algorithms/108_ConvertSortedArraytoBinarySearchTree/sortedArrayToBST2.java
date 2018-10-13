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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode result = helper(0, nums.length - 1, nums);

        return result;
    }

    public TreeNode helper(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode current = new TreeNode(nums[mid]);

        current.left = helper(start, mid - 1, nums);
        current.right = helper(mid + 1, end, nums);

        return current;
    }
}
