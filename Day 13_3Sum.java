import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();
        
        // Sort the input array.
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values to avoid duplicate triplets.
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i];
                
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        // Found a triplet that sums up to 0.
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        
                        // Skip duplicate values.
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        // Move the pointers.
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}