class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();

        for (String str : A.split(" ")) {
            count.put(str, count.getOrDefault(str, 0) + 1);
        }

        for (String str : B.split(" ")) {
            count.put(str, count.getOrDefault(str, 0) + 1);
        }

        List<String> result = new ArrayList<>();

        for (String key : count.keySet()) {
            if (count.get(key) == 1) {
                result.add(key);
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
