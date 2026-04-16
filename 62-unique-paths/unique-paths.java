class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;
        for (int i = 1; i <= Math.min(m - 1, n - 1); i++) {
            result = result * (m + n - 1 - i) / i;
        }
        return (int) result;
    }
}