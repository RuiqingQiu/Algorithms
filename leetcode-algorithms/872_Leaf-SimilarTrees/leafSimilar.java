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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> lst1 = new ArrayList<Integer>();
        List<Integer> lst2 = new ArrayList<Integer>();

        helper(lst1, root1);
        helper(lst2, root2);

        if (lst1.size() != lst2.size()) {
            return false;
        }

        for (int i = 0; i < lst1.size(); i++) {
            if (lst1.get(i) != lst2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void helper(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        helper(result, root.left);
        helper(result, root.right);
    }
}
