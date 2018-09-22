class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // find closest

        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        while (result.size() != k) {
            int ldiff = left >= 0 ? x - arr[left] : Integer.MAX_VALUE;
            int rdiff = right < arr.length ? arr[right] - x : Integer.MAX_VALUE;

            if (ldiff > rdiff) {
                result.add(arr[right++]);
            } else {
                result.add(0, arr[left--]);
            }
        }
        return result;
    }
}
