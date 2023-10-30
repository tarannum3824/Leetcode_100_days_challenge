class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // Needle is an empty string, return 0.
        }
        if (haystack.length() < needle.length()) {
            return -1; // Needle is longer than haystack, impossible to find.
        }
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Found a match, return the index.
            }
        }
        
        return -1; // No match found, return -1.
    }
}