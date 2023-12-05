class Solution {
    public String countAndSay(int n) {
         if (n == 1) {
            return "1";
        } else {
            String prev = countAndSay(n - 1);
            StringBuilder result = new StringBuilder();
            int count = 1;
            
            for (int i = 0; i < prev.length(); i++) {
                if (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i + 1)) {
                    // If the current character is the same as the next one, increase the count
                    count++;
                } else {
                    // If the current character is different from the next one, append count and digit to the result
                    result.append(count).append(prev.charAt(i));
                    count = 1; // Reset count for the new digit
                }
            }
            
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int n1 = 1;
        System.out.println(solution.countAndSay(n1)); // Output: "1"
        
        // Example 2
        int n2 = 4;
        System.out.println(solution.countAndSay(n2)); // Output: "1211"
        
    }
}