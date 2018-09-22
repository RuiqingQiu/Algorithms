class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<Integer>();
        int current = n;

        while (visited.add(current)) {
            int result = 0;

            while (current > 0) {
                int digit = current % 10;
                current = current / 10;
                result += digit * digit;
            }

            if (result == 1) {
                return true;
            } else {
                current = result;
            }
        }

        return false;
    }
}
