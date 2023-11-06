class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long left = 0;
        long right = x;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) (left - 1);
    }
}