/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    int max = 0;

    public int maxDepth(Node root) {
        helper(1, root);
        return max;
    }

    private void helper(int depth, Node root) {
        if (root == null) {
            return;
        }

        max = Math.max(max, depth);

        for (Node node : root.children) {
            helper(depth + 1, node);
        }

    }
}
