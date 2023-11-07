class Solution {
    public int climbStairs(int n) {
         if (n == 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1; // 1 way to climb 1 step
        dp[2] = 2; // 2 ways to climb 2 steps (1 + 1 or 2)
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Number of ways to climb i steps is the sum of ways to climb i-1 and i-2 steps
        }
        
        return dp[n];
    }
}