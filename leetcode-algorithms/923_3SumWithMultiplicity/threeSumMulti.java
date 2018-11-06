class Solution {
    public int threeSumMulti(int[] A, int target) {
        return threeSum(A, target);
    }

    public int threeSum(int[] nums, int num) {
        Arrays.sort(nums);
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            // if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                int low = i + 1;
                int high = nums.length - 1;
                int target = num - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        int l = nums[low];
                        int r = nums[high];

                        int lcount = 0;
                        // System.out.println(nums[i] + ", " + l + ", " + r);
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                            lcount += 1;
                        }

                        int rcount = 0;
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                            rcount += 1;
                        }


                        if (l != r) {
                            // System.out.println("in not equal");
                            // System.out.println((lcount + 1) * (rcount + 1));
                            result += (lcount + 1) * (rcount + 1);
                        } else {
                            // System.out.println("in equal");
                            // System.out.println(lcount);
                            if (lcount < 2) {
                                // System.out.println(1);
                                result += 1;
                            } else {
                                // System.out.println((lcount + 1) * lcount / 2);
                                result += (lcount + 1) * lcount / 2;
                            }
                            // System.out.println(((lcount + 1) / 2) * (lcount / 2));
                        }

                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < target) {
                        low++;
                    } else {
                        high--;
                    }

                    result = result % 1000000007;
                }
        }

        return result % 1000000007;

    }

    public int factorial(int n)
    {
        int res = 1, i;
        for (i=2; i<=n; i++)
            res *= i;
        return res;
    }
}
