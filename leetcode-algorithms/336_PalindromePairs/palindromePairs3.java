class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String s = words[i];

            if (isPalidrome(s)) {
                if (map.containsKey("")) {
                    if (map.get("") != i) {
                        result.add(Arrays.asList(i, map.get("")));
                        result.add(Arrays.asList(map.get(""), i));
                    }
                }
            }

            String reversed = new StringBuilder(s).reverse().toString();

            if (map.containsKey(reversed)) {
                if (map.get(reversed) != i) {
                    result.add(Arrays.asList(i, map.get(reversed)));
                }
            }

            for (int k = 1; k < s.length(); k++) {
                String left = s.substring(0, k);
                String right = s.substring(k);

                if (isPalidrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();

                    if (map.containsKey(reversedRight)) {
                        if (map.get(reversedRight) != i) {
                            result.add(Arrays.asList(map.get(reversedRight), i));
                        }
                    }
                }

                if (isPalidrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();

                    if (map.containsKey(reversedLeft)) {
                        if (map.get(reversedLeft) != i) {
                            result.add(Arrays.asList(i, map.get(reversedLeft)));
                        }
                    }
                }


            }
        }

        return result;
    }

    private boolean isPalidrome(String current) {
        int start = 0;
        int end = current.length() - 1;

        while (start < end) {
            if (current.charAt(start) != current.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
