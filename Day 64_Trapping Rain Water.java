class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0; // Not enough bars to trap water
        }

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            // Update the maximum height on the left
            leftMax = Math.max(leftMax, height[left]);
            
            // Update the maximum height on the right
            rightMax = Math.max(rightMax, height[right]);

            // Calculate the trapped water at the current position
            if (height[left] < height[right]) {
                trappedWater += leftMax - height[left];
                left++;
            } else {
                trappedWater += rightMax - height[right];
                right--;
            }
        }

        return trappedWater;
    }
}
