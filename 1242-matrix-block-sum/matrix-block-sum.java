class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 1. Build the 2D Prefix Sum Table
        // Use (m+1)x(n+1) to handle edge cases (index 0) naturally
        int[][] pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] 
                                     + pref[i + 1][j] - pref[i][j];
            }
        }
        
        int[][] ans = new int[m][n];
        
        // 2. Calculate Block Sum for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Find boundaries of the k-radius block
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // Query the prefix sum table (indices shifted by +1)
                ans[i][j] = pref[r2 + 1][c2 + 1] 
                          - pref[r1][c2 + 1] 
                          - pref[r2 + 1][c1] 
                          + pref[r1][c1];
            }
        }
        
        return ans;
    }
}