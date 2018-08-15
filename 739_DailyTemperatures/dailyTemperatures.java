class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int [] result = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int days = 1;
            int current = temperatures[i];

            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] <= current) {
                    days++;
                } else {
                    result[i] = days;
                    break;
                }
            }
        }

        return result;
    }
}
