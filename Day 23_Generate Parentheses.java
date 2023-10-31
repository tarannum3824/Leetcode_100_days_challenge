import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> result = new ArrayList<>();
        generate("", n, n, result);
        return result;
    }

    private void generate(String current, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        if (left > 0) {
            generate(current + "(", left - 1, right, result);
        }

        if (right > left) {
            generate(current + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> combinations = solution.generateParenthesis(n);
        System.out.println(combinations);
    }
}