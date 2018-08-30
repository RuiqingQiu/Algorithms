class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (beginWord.compareTo(endWord) == 0) {
            return result;
        }

        // dictionary for all the words
        Set<String> dict = new HashSet<String>(wordList);
        // construct graph using bfs

        // track words that have been visited
        Set<String> visited = new HashSet<String>();

        List<String> queue = new ArrayList<String>();
        queue.add(beginWord);

        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        graph.put(endWord, new ArrayList<String>());

        boolean found = false;

        while(!queue.isEmpty() && !found) {
            List<String> tmp = new ArrayList<String>();

            for (int i = 0; i < queue.size(); i++) {
                visited.add(queue.get(i));
            }

            for (int i = 0; i < queue.size(); i++) {
                String str = queue.get(i);
                char[] word = str.toCharArray();

                for (int j = 0; j < word.length; j++) {
                    char before = word[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == before) {
                            continue;
                        }
                        word[j] = ch;

                        String tmpStr = new String(word);

                        if (!dict.contains(tmpStr)) {
                            continue;
                        }

                        if (found && endWord.compareTo(tmpStr) != 0) {
                            continue;
                        }

                        if (endWord.compareTo(tmpStr) == 0) {
                            found = true;
                            graph.get(endWord).add(str);
                            continue;
                        }

                        if (!visited.contains(tmpStr)) {
                            tmp.add(tmpStr);

                            if (!graph.containsKey(tmpStr)) {
                                graph.put(tmpStr, new ArrayList<String>());
                            }
                            graph.get(tmpStr).add(str);
                        }
                    }
                    word[j] = before;
                }
            }

            // add elements to al, including duplicates
            Set<String> hs = new HashSet<>();
            hs.addAll(tmp);
            tmp.clear();
            tmp.addAll(hs);

            queue = tmp;
        }

        if (found) {
            List<String> path = new ArrayList<String>();
            dfs(result, graph, path, beginWord, endWord);
        }

        return result;
    }

    private void dfs(List<List<String>> result, HashMap<String, List<String>> graph, List<String> path, String start, String now) {
        path.add(now);

        if (now.compareTo(start) == 0) {
            List<String> ans = new ArrayList<String>(path);
            Collections.reverse(ans);
            result.add(ans);
            path.remove(path.size() - 1);
            return;
        }

        List<String> neighbors = graph.get(now);

        for (int i = 0; i < neighbors.size(); i++) {
            dfs(result, graph, path, start, neighbors.get(i));
        }

        path.remove(path.size() - 1);
    }
}
