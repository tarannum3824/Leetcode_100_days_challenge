class Solution {
    public int longestValidParentheses(String s) {
         Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize the stack with -1 to handle cases where the first character is ')'
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // If the stack becomes empty, push the current index to act as a starting point
                    stack.push(i);
                } else {
                    // Calculate the length of the valid parentheses substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.longestValidParentheses("(()"));    // Output: 2
        System.out.println(solution.longestValidParentheses(")()())"));  // Output: 4
        System.out.println(solution.longestValidParentheses(""));   
    }
}