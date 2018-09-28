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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode successor = findSuccessor(root);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private TreeNode findSuccessor(TreeNode root) {
        TreeNode current = root.right;

        while (current != null && current.left != null) {
            current = current.left;
        }

        return current;
    }
}
