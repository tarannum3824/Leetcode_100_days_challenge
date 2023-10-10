class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; // left pointer
        int right = 0; // right pointer
        Set<Character> set = new HashSet<>();
        int max = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }
}