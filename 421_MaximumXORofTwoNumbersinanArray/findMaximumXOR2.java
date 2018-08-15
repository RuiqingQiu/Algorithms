class Solution {
    class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        TrieNode root = new TrieNode();

        for (int num : nums) {
            TrieNode tmp = root;

            for (int i = 31; i >= 0; i--) {
                int currentBit = (num >>> i) & 1;

                if (tmp.children[currentBit] == null) {
                    tmp.children[currentBit] = new TrieNode();
                }
                tmp = tmp.children[currentBit];
            }
        }
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            TrieNode tmp = root;
            int currentSum = 0;

            for (int i = 31; i >= 0; i--) {
                int currentBit = (num >>> i) & 1;

                if (tmp.children[currentBit ^ 1] != null) {
                    currentSum += (1 << i);
                    tmp = tmp.children[currentBit ^ 1];
                } else {
                    tmp = tmp.children[currentBit];
                }
            }

            max = Math.max(max, currentSum);
        }

        return max;
    }
}
