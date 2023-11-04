class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // Increment the current digit.
                return digits; // No carry, so return the result.
            } else {
                digits[i] = 0; // Set the current digit to 0 and continue with the next.
            }
        }
        
        // If we reach this point, it means we had all 9s, and there's a carry to the leftmost digit.
        int[] result = new int[n + 1];
        result[0] = 1; // Set the leftmost digit to 1.
        return result; 
    }
}