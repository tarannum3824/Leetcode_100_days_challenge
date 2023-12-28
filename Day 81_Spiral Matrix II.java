class Solution {
    public int[][] generateMatrix(int n) {
        // Initialize the matrix with zeros
        int[][] matrix = new int[n][n];

        // Define the directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDirection = 0;  // Start with moving right

        // Set the initial position
        int row = 0, col = 0;

        for (int i = 1; i <= n * n; i++) {
            // Fill the current cell
            matrix[row][col] = i;

            // Calculate the next cell
            int nextRow = row + directions[currentDirection][0];
            int nextCol = col + directions[currentDirection][1];

            // Check if the next cell is within the bounds and not already filled
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
                // Change direction
                currentDirection = (currentDirection + 1) % 4;
                nextRow = row + directions[currentDirection][0];
                nextCol = col + directions[currentDirection][1];
            }

            // Move to the next cell
            row = nextRow;
            col = nextCol;
        }

        return matrix;
    }
}
