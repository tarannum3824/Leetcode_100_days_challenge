class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int currentIndex = 2; // Start from the third element
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[currentIndex - 2]) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }

        return currentIndex;
    }
}
