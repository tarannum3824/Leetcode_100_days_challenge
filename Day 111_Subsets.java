import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.subsets(nums1);
        System.out.println("Example 1:");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);

        // Example 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println("Example 2:");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);
    }
}
