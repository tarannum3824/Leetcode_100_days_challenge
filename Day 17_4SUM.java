import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (nums == null || n < 4) {
            return result;
        }

        Arrays.sort(nums);

        long targetLong = (long) target; // Convert target to a long to handle large values

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Skip duplicates
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == targetLong) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < targetLong) {
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