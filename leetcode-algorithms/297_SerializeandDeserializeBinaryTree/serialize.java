/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        String result = "";

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                result += "null ";
            } else {
                result += current.val + " ";
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        TreeNode root = null;

        if (nodes[0].equals("null")) {
            return root;
        } else {
            root = new TreeNode(Integer.parseInt(nodes[0]));
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (!nodes[index].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[index++]));
                current.left = left;
                queue.offer(left);
            } else {
                index++;
            }

            if (!nodes[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[index++]));
                current.right = right;
                queue.offer(right);
            } else {
                index++;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
