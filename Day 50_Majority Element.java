class Solution {
    public int majorityElement(int[] nums) {
         int candidate = nums[0];
        int count = 1;
        
        // First pass: Find the potential majority element
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        
        // Second pass: Verify if the potential majority element is the majority
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        
        // The majority element always exists, so no need to check if count > 0
        
        return candidate;
    }
}