class Solution {
    public String convertToTitle(int columnNumber) {
         StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjusting for 0-based index
            int remainder = columnNumber % 26;
            char charToAdd = (char) ('A' + remainder);
            result.insert(0, charToAdd);
            columnNumber /= 26;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.convertToTitle(1));   // Output: "A"
        System.out.println(solution.convertToTitle(28));  // Output: "AB"
        System.out.println(solution.convertToTitle(701)); // Output: "ZY"
    }
}