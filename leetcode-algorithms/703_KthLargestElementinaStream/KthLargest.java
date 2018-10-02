class KthLargest {
    class TreeNode {
        int val;
        int count = 1;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode root;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            root = add(root, num);
        }
    }

    private TreeNode add(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        root.count++;
        if (val < root.val) {
            root.left = add(root.left, val);
        } else {
            root.right = add(root.right, val);
        }

        return root;
    }

    public int add(int val) {
        root = add(root, val);

        return findKthLargest();
    }

    public int findKthLargest() {
        int count = k;
        TreeNode current = root;

        while (count > 0) {
            int position = 1;

            if (current.right != null) {
                position += current.right.count;
            }

            if (count == position) {
                break;
            } else if (count > position) {
                count -= position;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current.val;
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
