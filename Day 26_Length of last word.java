class Solution {
    public int lengthOfLastWord(String s) {
         s = s.trim(); // Remove extra spaces using trim() function
        int length = 0; // Initialize the length of the last word to 0

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                break;
            }
        }

        return length;
    }
}