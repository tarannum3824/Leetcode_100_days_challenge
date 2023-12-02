class Solution {
    public void nextPermutation(int[] nums) {
         int n = nums.length;
        
        // Step 1: Find the first pair (i, i+1) from the right such that nums[i] < nums[i+1]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // Step 2: Find the first element from the right that is greater than nums[i] (nums[j])
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            
            // Step 3: Swap nums[i] and nums[j]
            swap(nums, i, j);
        }
        
        // Step 4: Reverse the sub-array nums[i+1:]
        reverse(nums, i + 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}