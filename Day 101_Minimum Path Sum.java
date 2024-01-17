class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Iterate over each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Top left cell, no action needed
                } else if (i == 0) {
                    // Top row, can only come from the left
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    // Leftmost column, can only come from above
                    grid[i][j] += grid[i - 1][j];
                } else {
                    // Choose the minimum path from top or left
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        // The bottom-right cell now contains the minimum path sum
        return grid[m - 1][n - 1];
    }
}
