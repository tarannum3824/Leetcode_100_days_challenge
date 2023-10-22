class Solution {
    public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums); // Sort the array to simplify the solution.
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the sum of the first three numbers.

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}