class Solution {
    public int myAtoi(String s) {
          int index = 0;
        int sign = 1;
        int result = 0;
        boolean started = false;
        
        // Step 1: Ignore leading whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        
        // Step 2: Check for '+' or '-' to determine the sign
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        
        // Step 3: Read in characters until a non-digit character is encountered
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            // Step 4: Check for integer overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
            started = true;
        }
        
        // If no digits were read, return 0
        if (!started) {
            return 0;
        }
        
        return sign * result;
    }
}