class Solution {
    public int removeElement(int[] nums, int val) {
         int k = 0; // Initialize the pointer for non-equal elements
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move the non-equal element to the correct position
                k++; // Increment the non-equal element count
            }
        }
        
        return k;
    }
}