public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        sort(A, 0, A.length - 1);
    }

    private void merge(int[] A, int start, int end) {
        int mid = start + (end - start) / 2;
        int i = 0;
        int j = 0;
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int k = 0; k < left.length; k++) {
            left[k] = A[k + start];
        }

        for (int k = 0; k < right.length; k++) {
            right[k] = A[k + mid + 1];
        }

        int index = start;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                A[index++] = left[i++];
            } else {
                A[index++] = right[j++];
            }
        }

        while (i < left.length) {
            A[index++] = left[i++];
        }

        while (j < right.length) {
            A[index++] = right[j++];
        }
    }

    private void sort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        sort(A, start, mid);
        sort(A, mid + 1, end);
        merge(A, start, end);
    }
}
