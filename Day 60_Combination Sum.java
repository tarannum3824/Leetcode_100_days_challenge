import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates efficiently
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remainingTarget, int start) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remainingTarget) {
                // If the current candidate is greater than the remaining target, skip it
                break;
            }

            currentList.add(candidates[i]);
            backtrack(result, currentList, candidates, remainingTarget - candidates[i], i);
            currentList.remove(currentList.size() - 1);
        }
    }
}
