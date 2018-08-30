/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        helper(root, stack);
    }

    private void helper(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        helper(current.right, stack);
        return current.val;
    }
    // List<TreeNode> lst;
    // int index;
    // public BSTIterator(TreeNode root) {
    //     lst = new ArrayList<TreeNode>();
    //     index = 0;
    //     helper(lst, root);
    // }
    //
    // private void helper(List<TreeNode> lst, TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //
    //     helper(lst, root.left);
    //     lst.add(root);
    //     helper(lst, root.right);
    // }
    //
    // /** @return whether we have a next smallest number */
    // public boolean hasNext() {
    //     if (index < lst.size()) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
    //
    // /** @return the next smallest number */
    // public int next() {
    //     return lst.get(index++).val;
    // }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
