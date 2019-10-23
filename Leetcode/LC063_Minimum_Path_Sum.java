/**
 * https://leetcode.com/problems/minimum-path-sum/
 * P064 Minimum Path Sum
 * Medium
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 */
class LC063_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid[0].length;
        int n = grid.length;

        for (int mm = 0; mm < m; mm += 1) {
            for (int nn = 0; nn < n; nn += 1) {
                if (nn == 0 && mm == 0) {

                } else if (nn == 0) {
                    grid[nn][mm] = grid[nn][mm] + grid[nn][mm - 1];
                } else if (mm == 0) {
                    grid[nn][mm] = grid[nn][mm] + grid[nn - 1][mm];
                } else {
                    grid[nn][mm] = grid[nn][mm] + Math.min(grid[nn][mm - 1], grid[nn - 1][mm]);
                }
            }
        }

        return grid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] e1 = new int[][]{
                {}
        };
        assert new LC063_Minimum_Path_Sum().minPathSum(e1) == 0 : "Edge 1";

        int[][] e2 = new int[][]{
                {1}
        };
        assert new LC063_Minimum_Path_Sum().minPathSum(e2) == 1 : "Edge 2";

        int[][] e3 = new int[][]{
                {1, 1}
        };
        assert new LC063_Minimum_Path_Sum().minPathSum(e3) == 2 : "Edge 3";

        int[][] e4 = new int[][]{
                {1},
                {1}
        };
        assert new LC063_Minimum_Path_Sum().minPathSum(e4) == 2 : "Edge 4";

        int[][] s1 = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        assert new LC063_Minimum_Path_Sum().minPathSum(s1) == 7 : "Example 1";

        System.out.println("all passed");
    }

}
