class Solution {

    // O(n) solution
    public int trap(int [] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int [] left = new int[n];
        int [] right = new int[n];

        left[0] = height[0];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            // my thought of only compute water difference when the smaller max is taller than curernt
            // int smallerMax = Math.min(left[i], right[i]);
            //
            // if (smallerMax > height[i]);
            //     result += smallerMax - height[i];

            // Standard solution, will cancel extra out
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
    // O(n^2) solution
    // public int trap(int[] height) {
    //     int result = 0;
    //
    //     for (int i = 1; i < height.length - 1; i++) {
    //         int smallerMax = Math.min(getMax(height, 0, i), getMax(height, i, height.length));
    //
    //         if (smallerMax > height[i]) {
    //             result += smallerMax - height[i];
    //         }
    //     }
    //
    //     return result;
    // }
    //
    // public int getMax(int[] height, int start, int end) {
    //     int max = height[start];
    //
    //     for (int i = start; i < end; i++) {
    //         max = Math.max(height[i], max);
    //     }
    //
    //     return max;
    // }
}
