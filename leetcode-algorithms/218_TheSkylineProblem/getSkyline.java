class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for (int[] building : buildings) {
            height.add(new int[]{building[0], -building[2]});
            height.add(new int[]{building[1], building[2]});
        }

        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        pq.offer(0);

        int previous = 0;

        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }

            int current = pq.peek();

            if (previous != current) {
                result.add(new int[]{h[0], current});
                previous = current;
            }
        }

        return result;
    }
    // public List<int[]> getSkyline(int[][] buildings) {
    //     List<int[]> result = new ArrayList<>();
    //
    //     if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
    //         return result;
    //     }
    //
    //     int min = Integer.MAX_VALUE;
    //     int max = 0;
    //
    //     for (int i = 0; i < buildings.length; i++) {
    //         min = Math.min(buildings[i][0], min);
    //         max = Math.max(buildings[i][1], max);
    //     }
    //
    //     int[] highest = new int[max - min + 1];
    //
    //     for (int i = 0; i < buildings.length; i++) {
    //         for (int j = buildings[i][0]; j <= buildings[i][1]; j++) {
    //             highest[j - min] = Math.max(highest[j - min], buildings[i][2]);
    //         }
    //     }
    //
    //     int previous = highest[0];
    //     result.add(new int[]{min, highest[0]});
    //
    //     for (int i = 1; i < highest.length; i++) {
    //         if (previous == highest[i]) {
    //             continue;
    //         } else {
    //             if (previous > highest[i]) {
    //                 result.add(new int[] {i + min - 1, highest[i]});
    //             } else {
    //                 result.add(new int[] {i + min, highest[i]});
    //             }
    //
    //             previous = highest[i];
    //         }
    //     }
    //     result.add(new int[]{max, 0});
    //
    //     return result;
    // }
}
