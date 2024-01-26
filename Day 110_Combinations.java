import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(result, current, i + 1, n, k - 1);
            current.remove(current.size() - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int n1 = 4, k1 = 2;
        List<List<Integer>> result1 = solution.combine(n1, k1);
        System.out.println("Combinations for n = " + n1 + ", k = " + k1 + ": " + result1);

        // Example 2
        int n2 = 1, k2 = 1;
        List<List<Integer>> result2 = solution.combine(n2, k2);
        System.out.println("Combinations for n = " + n2 + ", k = " + k2 + ": " + result2);
    }
}
