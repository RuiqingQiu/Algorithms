class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    return mergeNode(t1, t2)
  }

  public TreeNode mergeNode(TreeNode current, TreeNode other) {
    TreeNode result = new TreeNode(0);
    if (current != null) {
      result = current;
    }
    if (other != null) {
      result.val += other.val;
    }
    if (other.left != null) {
      current.left = mergeNode(current.left, other.left);
    }
    if (other.right != null) {
      current.right = mergeNode(current.right, other.right);
    }
    return result;
  }
}
