class Solution {
    public int findCoverage(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int totalCoverage = 0;
        
        // Directions arrays for up, down, left, and right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // Iterate through each cell in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check if the current cell is zero
                if (matrix[i][j] == 0) {
                    // Check all four directions
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        
                        // Check if the neighboring cell is within bounds and is one
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m && matrix[ni][nj] == 1) {
                            totalCoverage++;
                        }
                    }
                }
            }
        }
        
        return totalCoverage;
    }
}
