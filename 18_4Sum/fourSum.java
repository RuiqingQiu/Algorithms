class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1];

        if (4 * max < target || 4 * nums[0] > target) {
            return result;
        }

        for (int i = 0; i < len; i++) {
            int current = nums[i];

            // avoid duplicate
            if (i > 0 && current == nums[i - 1]) {
                continue;
            }

            // current number is too small
            if (current + 3 * max < target) {
                continue;
            }

            // current number is too large
            if (4 * current > target) {
                break;
            }

            if (4 * current == target) {
                if (i + 3 < len && nums[i + 3] == current) {
                    result.add(Arrays.asList(current, current, current, current));
                }
                break;
            }

            threeSumForFourSum(nums, target - current, i + 1, len - 1, result, current);
        }

        return result;
    }

    private void threeSumForFourSum(int[] nums, int target, int left, int right,
                                    List<List<Integer>> result, int current) {
        if (left >= right) {
            return;
        }

        int max = nums[right];

        if (3 * nums[left] > target || 3 * max < target) {
            return;
        }

        for (int i = left; i < right - 1; i++) {
            int j = nums[i];

            if (i > left && j == nums[i - 1]) {
                continue;
            }

            if (j + 2 * max < target) {
                continue;
            }

            if (3 * j > target) {
                break;
            }

            if (3 * j == target) {
                if (i + 1 < right && nums[i + 2] == j) {
                    result.add(Arrays.asList(current, j, j, j));
                    break;
                }
            }

            twoSumForFourSum(nums, target - j, i + 1, right, result, current, j);
        }
    }

    private void twoSumForFourSum(int[] nums, int target, int left, int right,
                                    List<List<Integer>> result, int current, int j) {
        if (left >= right) {
            return;
        }

        if (2 * nums[left] > target || 2 * nums[right] < target) {
            return;
        }

        int low = left;
        int high = right;

        while (low < high) {
            int sum = nums[low] + nums[high];

            if (sum == target) {
                result.add(Arrays.asList(nums[low], nums[high], current, j));

                while (low < high && nums[low] == nums[low + 1]) {
                    low++;
                }

                while (low < high && nums[high] == nums[high - 1]) {
                    high--;
                }
            }

            if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
    }
}
