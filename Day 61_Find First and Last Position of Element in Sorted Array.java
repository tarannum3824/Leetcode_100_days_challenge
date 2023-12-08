class Solution {
    public int[] searchRange(int[] nums, int target) {
         int[] result = {-1, -1};
        
        // Find the first occurrence of the target
        result[0] = findFirstOccurrence(nums, target);
        
        // Find the last occurrence of the target
        result[1] = findLastOccurrence(nums, target);
        
        return result;
    }
    
    private int findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int firstOccurrence = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                right = mid - 1;
                if (nums[mid] == target) {
                    firstOccurrence = mid;
                }
            } else {
                left = mid + 1;
            }
        }
        
        return firstOccurrence;
    }
    
    private int findLastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int lastOccurrence = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                left = mid + 1;
                if (nums[mid] == target) {
                    lastOccurrence = mid;
                }
            } else {
                right = mid - 1;
            }
        }
        
        return lastOccurrence;
    }
}