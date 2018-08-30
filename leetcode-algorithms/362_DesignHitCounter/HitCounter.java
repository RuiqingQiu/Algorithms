class HitCounter {
    int [] time;
    int [] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        time = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;

        if (time[index] != timestamp) {
            time[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index] += 1;
        }
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;

        for (int i = 0; i < 300; i++) {
            if (timestamp - time[i] < 300) {
                total += hits[i];
            }
        }

        return total;
    }

    // HashMap<Integer, Integer> mapOfCounts;
    // /** Initialize your data structure here. */
    // public HitCounter() {
    //     mapOfCounts = new HashMap<Integer, Integer>();
    // }
    //
    // /** Record a hit.
    //     @param timestamp - The current timestamp (in seconds granularity). */
    // public void hit(int timestamp) {
    //     if (mapOfCounts.containsKey(timestamp)) {
    //         mapOfCounts.put(timestamp, mapOfCounts.get(timestamp) + 1);
    //     } else {
    //         mapOfCounts.put(timestamp, 1);
    //     }
    // }
    //
    // /** Return the number of hits in the past 5 minutes.
    //     @param timestamp - The current timestamp (in seconds granularity). */
    // public int getHits(int timestamp) {
    //     int total = 0;
    //
    //     for (int i = timestamp - 300 + 1 ; i <= timestamp; i++) {
    //         if (mapOfCounts.containsKey(i)) {
    //             total += mapOfCounts.get(i);
    //         }
    //     }
    //
    //     return total;
    // }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
