public class Dynamic {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                dp[row][col] = -1;
            }

        }

        return process(grid, grid.length - 1, grid[0].length - 1, dp);
    }

    public static int process(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans;
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (j > 0) {
            down = process(grid, i, j - 1, dp);
        }
        if (i > 0) {
            right = process(grid, i - 1, j, dp);
        }
        ans = grid[i][j] + Math.min(down, right);
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum(grid));
    }
}