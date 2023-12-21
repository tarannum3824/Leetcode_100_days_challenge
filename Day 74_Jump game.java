class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach || maxReach >= nums.length - 1) {
                return maxReach >= nums.length - 1;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return false;
    }
}
