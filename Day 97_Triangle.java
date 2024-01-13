import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Number of rows in the triangle
        int n = triangle.size();

        // Array to store the minimum path sum at each element
        int[] dp = new int[n];

        // Initialize the last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Iterate from the second last row to the first row
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Choose the minimum path sum from the two adjacent numbers in the row below
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }

        // The top element now contains the minimum path sum
        return dp[0];
    }
}
