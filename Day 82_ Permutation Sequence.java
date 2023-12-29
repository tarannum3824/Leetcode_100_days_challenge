import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            nums.add(i);
            factorial[i] = i * factorial[i - 1];
        }

        k--; // Convert k to 0-based index
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            result.append(nums.get(index));
            nums.remove(index);
            k %= factorial[n - i];
        }

        return result.toString();
    }
}
