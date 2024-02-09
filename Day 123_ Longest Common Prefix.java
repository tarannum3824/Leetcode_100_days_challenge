class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Iterate through characters of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            // Compare the character with corresponding characters in other strings
            for (int j = 1; j < strs.length; j++) {
                // If index i is out of range for the current string or characters don't match, return the prefix found so far
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // If all characters match, return the first string (or any string, since they're all equal)
        return strs[0];
    }
}
