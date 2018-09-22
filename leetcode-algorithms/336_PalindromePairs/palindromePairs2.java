class Solution {
    class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<Integer>();
        }
    }

    // O(nk^2) solution using trie
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addToTrie(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words, i, root, result);
        }

        return result;
    }

    private void addToTrie(TrieNode root, String current, int index) {
        for (int i = current.length() - 1; i >= 0; i--) {
            int j = current.charAt(i) - 'a';

            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }

            if (isPalidrome(current, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i
                    && isPalidrome(words[i], j, words[i].length() - 1)) {
                result.add(Arrays.asList(i, root.index));
            }
            root = root.next[words[i].charAt(j) - 'a'];

            if (root == null) {
                return;
            }
        }

        for (int j : root.list) {
            if (i == j) {
                continue;
            }
            result.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalidrome(String current, int i, int j) {
        while (i < j) {
            if (current.charAt(i) != current.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}
