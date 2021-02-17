class Solution {
    public List<String> letterCasePermutation(String S) {
        HashSet<String> result = new HashSet<String>();
        helper(result, S, 0);

        return new ArrayList<String>(result);
    }

    private void helper(HashSet<String> result, String current, int pos) {
        if (pos == current.length()) {
            return;
        }

        if (current.charAt(pos) - 'a' <= 26 || current.charAt(pos) - 'A' <= 26) {
            String tmp = current.substring(0, pos) + current.substring(pos, pos + 1).toUpperCase() + current.substring(pos + 1);
            result.add(tmp);
            helper(result, tmp, pos + 1);
            tmp = current.substring(0, pos) + current.substring(pos, pos + 1).toLowerCase() + current.substring(pos + 1);
            result.add(tmp);
            helper(result, tmp, pos + 1);
        } else {
            helper(result, current, pos + 1);
        }
    }
}
