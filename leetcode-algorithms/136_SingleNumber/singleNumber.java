class Solution {
    public int singleNumber(int[] nums) {
        // Bit XOR
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
