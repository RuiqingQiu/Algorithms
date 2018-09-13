class Solution {
    int diff = Integer.MAX_VALUE;
    String result = "";

    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<Integer>();

        set.add(Integer.parseInt(time.substring(0, 1)));
        set.add(Integer.parseInt(time.substring(1, 2)));
        set.add(Integer.parseInt(time.substring(3, 4)));
        set.add(Integer.parseInt(time.substring(4, 5)));

        if (set.size() == 1) {
            return time;
        }

        List<Integer> digits = new ArrayList<Integer>(set);
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60
                        + Integer.parseInt(time.substring(3, 5));
        helper(digits, minutes, 0, "");

        return result;
    }

    private void helper(List<Integer> digits, int minute, int position, String current) {

        if (position == 4) {
            int currentMinute = Integer.parseInt(current.substring(0, 2)) * 60
                                + Integer.parseInt(current.substring(2, 4));
            if (currentMinute == minute) {
                return;
            }

            int currentDiff = currentMinute - minute > 0
                                ? currentMinute - minute : 1440 + currentMinute - minute;

            if (currentDiff < diff) {
                diff = currentDiff;
                result = current.substring(0, 2) + ":" + current.substring(2, 4);
            }

            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (position == 0 && digits.get(i) > 2) {
                continue;
            } else if (position == 1 && Integer.parseInt(current) * 10 + digits.get(i) > 23) {
                continue;
            } else if (position == 2 && digits.get(i) > 5) {
                continue;
            } else if (position == 3 && Integer.parseInt(current.substring(2)) * 10 + digits.get(i) > 59) {
                continue;
            }
            helper(digits, minute, position + 1, current + digits.get(i));
        }
    }
}
