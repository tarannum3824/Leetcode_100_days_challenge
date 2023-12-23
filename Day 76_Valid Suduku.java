class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }
        
        // Check each column
        for (int j = 0; j < 9; j++) {
            if (!isValidColumn(board, j)) {
                return false;
            }
        }
        
        // Check each 3x3 sub-box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubBox(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            char value = board[row][j];
            if (value != '.' && !set.add(value)) {
                return false; // Duplicate found
            }
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char value = board[i][col];
            if (value != '.' && !set.add(value)) {
                return false; // Duplicate found
            }
        }
        return true;
    }
    
    private boolean isValidSubBox(char[][] board, int startRow, int startCol) {
        Set<Character> set = new HashSet<>();
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                char value = board[i][j];
                if (value != '.' && !set.add(value)) {
                    return false; // Duplicate found
                }
            }
        }
        return true;
    }
}
