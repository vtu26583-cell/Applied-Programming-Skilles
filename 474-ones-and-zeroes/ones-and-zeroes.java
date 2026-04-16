class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (String s : strs) {
            int[] counts = countZerosOnes(s);
            int zeros = counts[0];
            int ones = counts[1];
            
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
    
    private int[] countZerosOnes(String s) {
        int[] counts = new int[2];
        for (char c : s.toCharArray()) {
            counts[c - '0']++;
        }
        return counts;
    }
}