public class Solution {
    public int uniquePaths(int m, int n) {
        long paths = 1;
        int j = 1;

        // We choose the smaller one between (m-1) and (n-1) to iterate less
        int smaller = Math.min(m - 1, n - 1);

        for (int i = smaller; i > 0; i--) {
            paths *= (m + n - 1 - j);
            paths /= j;
            j++;
        }

        return (int) paths;
    }
}
