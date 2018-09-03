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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();

        helper(result, root);

        return result;
    }

    public void helper(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        for (Node child : root.children) {
            helper(result, child);
        }
    }
}
