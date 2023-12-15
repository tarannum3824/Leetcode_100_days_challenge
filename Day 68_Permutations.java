import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, result, currentPermutation, used);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> currentPermutation, boolean[] used) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPermutation.add(nums[i]);
                backtrack(nums, result, currentPermutation, used);
                used[i] = false;
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0, 1};
        int[] nums3 = {1};

        System.out.println(solution.permute(nums1));
        System.out.println(solution.permute(nums2));
        System.out.println(solution.permute(nums3));
    }
}
