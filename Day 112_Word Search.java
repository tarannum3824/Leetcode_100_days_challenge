class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(k)) {
            return false;
        }

        char original = board[i][j];
        board[i][j] = '*'; // Mark the current cell as visited

        boolean result = search(board, word, i + 1, j, k + 1) ||
                         search(board, word, i - 1, j, k + 1) ||
                         search(board, word, i, j + 1, k + 1) ||
                         search(board, word, i, j - 1, k + 1);

        board[i][j] = original; // Restore the original value

        return result;
    }
}
