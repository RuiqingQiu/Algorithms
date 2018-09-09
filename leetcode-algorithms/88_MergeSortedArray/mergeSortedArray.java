public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1;
        int j = n - 1;
        int k = A.length -  1;

        while (k >= 0) {
            if (i >= 0 && j >= 0 && A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                if (j >= 0) {
                    A[k--] = B[j--];
                } else {
                    break;
                }
            }
        }
    }
}
