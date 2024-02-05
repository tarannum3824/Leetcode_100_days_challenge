public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Iterate through each bit position
        for (int i = 0; i < 32; i++) {
            int sum = 0;

            // Count the number of set bits at the current bit position
            for (int num : nums) {
                sum += (num >> i) & 1;
            }

            // Set the bit in the result if the count is not a multiple of 3
            result |= (sum % 3) << i;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums1)); // Output: 3

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(solution.singleNumber(nums2)); // Output: 99
    }
}
