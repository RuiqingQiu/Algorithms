class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : deck) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }

            map.put(i, map.get(i) + 1);
        }
        
        int g = -1;

        for (int i : map.keySet()) {
            if (g == -1) {
                g = map.get(i);
            } else {
                g = gcd(g, map.get(i));
            }
        }

        return g >= 2;

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd (b, a % b);
        }
    }
}
