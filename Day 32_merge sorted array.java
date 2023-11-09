class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int index1 = m - 1; // Index for the last element of nums1
        int index2 = n - 1; // Index for the last element of nums2
        int mergedIndex = m + n - 1; // Index for the merged array

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[mergedIndex] = nums1[index1];
                index1--;
            } else {
                nums1[mergedIndex] = nums2[index2];
                index2--;
            }
            mergedIndex--;
        }

        // If there are remaining elements in nums2, copy them into nums1
        while (index2 >= 0) {
            nums1[mergedIndex] = nums2[index2];
            index2--;
            mergedIndex--;
        }
    }
}