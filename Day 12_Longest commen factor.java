class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);

            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return commonPrefix.toString();
                }
            }

            commonPrefix.append(c);
        }

        return commonPrefix.toString();
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs1)); // Output: "fl"
        System.out.println(solution.longestCommonPrefix(strs2)); // Output: ""
    }
}