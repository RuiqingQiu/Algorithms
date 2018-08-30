Class Solution {
    public double findMedianSortedArray(int [] arr1, int [] arr2) {
        if ((nums1 == null && nums2 == null) ||
            (nums1.length == 0 && nums2.length == 0)
                ) {
            return -1;
        }
        if (nums1 == null || nums1.length == 0) {
            int medianAt = nums2.length / 2;
            if (nums2.length % 2 == 0) {
                return (nums2[medianAt] + nums2[medianAt-1]) / 2.0;
            } else {
                return nums2[medianAt] / 1.0;
            }
        }
        if (nums2 == null || nums2.length == 0) {
            int medianAt = nums1.length / 2;
            if (nums1.length % 2 == 0) {
                return (nums1[medianAt] + nums1[medianAt-1]) / 2.0;
            } else {
                return nums1[medianAt] / 1.0;
            }
        }
        int totalLength = nums1.length + nums2.length;
        int medianAt = totalLength / 2;
        int i = 0; int j = 0; int counter = 0;
        int current = 0;
        int prev = 0;
        if (nums1[i] > nums2[j]) {
            current = nums2[j];
        } else {
            current = nums1[i];
        }
        while (counter <= medianAt) {
            prev = current;
            if (i == nums1.length) {
                current = nums2[j];
                j++;
            } else if (j == nums2.length) {
                current = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                current = nums2[j];
                j++;
            } else {
                current = nums1[i];
                i++;
            }
            counter++;
        }
        if (totalLength % 2 == 0){
            return (current + prev) / 2.0;
        } else {
            return current / 1.0;
        }

    }

}
