class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();

        for (String str : A.split(" ")) {
            if (!count.containsKey(str)) {
                count.put(str, 1);
            } else {
                count.put(str, count.get(str) + 1);
            }
        }

        HashMap<String, Integer> countB = new HashMap<String, Integer>();

        for (String str : B.split(" ")) {
            if (!countB.containsKey(str)) {
                countB.put(str, 1);
            } else {
                countB.put(str, countB.get(str) + 1);
            }
        }

        List<String> result = new ArrayList<String>();

        for (String key : count.keySet()) {
            if (!countB.containsKey(key) && count.get(key) == 1) {
                result.add(key);
            }
        }

        for (String key : countB.keySet()) {
            if (!count.containsKey(key) && countB.get(key) == 1) {
                result.add(key);
            }
        }

        String[] resultArr = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}
