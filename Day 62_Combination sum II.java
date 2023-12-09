import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates

        backtrack(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Skip if the current candidate is greater than the remaining target
            if (candidates[i] > remaining) {
                break;
            }

            // Include the current candidate in the combination
            currentList.add(candidates[i]);

            // Recursively explore further combinations
            backtrack(result, currentList, candidates, remaining - candidates[i], i + 1);

            // Backtrack by removing the last added element to try other combinations
            currentList.remove(currentList.size() - 1);
        }
    }
}
