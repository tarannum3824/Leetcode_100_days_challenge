class Solution {
    public boolean isPalindrome(String s) {
         // Convert to lowercase and remove non-alphanumeric characters
        StringBuilder filtered = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                filtered.append(Character.toLowerCase(ch));
            }
        }

        // Check if the filtered string is a palindrome
        int left = 0, right = filtered.length() - 1;
        while (left < right) {
            if (filtered.charAt(left) != filtered.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}