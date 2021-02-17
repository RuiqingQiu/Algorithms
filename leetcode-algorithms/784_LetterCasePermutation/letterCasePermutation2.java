class Solution {
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String current = queue.poll();
                char[] tmp = current.toCharArray();

                tmp[i] = Character.toUpperCase(tmp[i]);
                queue.offer(String.valueOf(tmp));

                tmp[i] = Character.toLowerCase(tmp[i]);
                queue.offer(String.valueOf(tmp));
            }

        }

        return new LinkedList<>(queue);
    }
}
