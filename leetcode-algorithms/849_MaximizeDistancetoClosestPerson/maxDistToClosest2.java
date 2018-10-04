class Solution {
    public int maxDistToClosest(int[] seats) {
        int count = 0;
        int result = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                count = 0;
            } else {
                count++;
                result = Math.max(result, (count + 1) / 2);
            }
        }

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                result = Math.max(result, i);
                break;
            }
        }

        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                result = Math.max(result, seats.length - 1 - i);
                break;
            }
        }

        return result;
    }
}
