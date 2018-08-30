class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);
        int step = 1;

        while (!queue.isEmpty()) {
            String tmp = queue.poll();

            if (endWord.equals(tmp)) {
                return step;
            }

            if (tmp == null && !queue.isEmpty()) {
                step += 1;
                queue.add(null);
            } else if (!queue.isEmpty()) {
                for (int i = 0; i < tmp.length(); i++) {
                    for (int j = 'a'; j <= 'z'; j++) {
                        String toBeTested = tmp.substring(0, i) + (char)j + tmp.substring(i+1);
                        if (!visited.contains(toBeTested)&& dict.contains(toBeTested)) {
                            visited.add(toBeTested);
                            queue.add(toBeTested);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
