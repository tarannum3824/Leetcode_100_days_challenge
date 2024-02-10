class Solution {
    public int numDecodings(String s) {
        // Initialize variables to represent counts of decoding ways
        int a = 1;  // Represents the number of ways to decode the string ending at the current character
        int b = 1;  // Represents the number of ways to decode the string ending at the previous character
        int c = 0;  // Temporary variable for swapping during zero-handling

        // Iterate through the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            // Check for invalid decoding (e.g., '30' or '40-90')
            if (s.charAt(i) == '0' && (s.charAt(i - 1) > '2' || s.charAt(i - 1) < '1')) {
                return 0;
            } 
            // Check for valid two-digit mapping
            else if (s.charAt(i - 1) != '0' && ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0')) < 27) {
                // Handle zero in the current digit
                if (s.charAt(i) == '0') {
                    c = b;
                    b = a;
                    a = c;
                    continue;
                } 
                // Update counts for non-zero cases
                else {
                    c = b;
                    b = a;
                    a = a + c;
                    continue;
                }
            } 
            // Handle one-digit mapping
            else {
                b = a;
                continue;
            }
        }

        // Check for invalid starting character
        if (s.charAt(0) == '0') {
            return 0;
        }

        // Return the final count representing the total number of ways to decode the string
        return a;
    }
}
