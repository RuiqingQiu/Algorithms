/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    HashSet<Integer> numbers;
    
    public FindElements(TreeNode root) {
        numbers = new HashSet<Integer>();

        // Recursive fill the tree.
        if (root != null) {
            root.val = 0;
        }

        fillElements(root);
    }

    private void fillElements(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = root.val * 2 + 1;
            numbers.add(root.left.val);
        }

        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
            numbers.add(root.right.val);
        }
        fillElements(root.left);
        fillElements(root.right);
    }

    public boolean find(int target) {
        return numbers.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
