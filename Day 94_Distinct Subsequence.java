class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp array to store the number of distinct subsequences
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the dp array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    // An empty string is a subsequence of any string
                    dp[i][j] = 1;
                } else if (i == 0) {
                    // An empty string can't match a non-empty string
                    dp[i][j] = 0;
                } else {
                    // If the characters match, consider both including and excluding the current character
                    dp[i][j] = dp[i - 1][j];
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }
}