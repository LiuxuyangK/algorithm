package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther eleme
 * @time 2020/5/31 5:36 下午
 * @desc
 */
public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum client = new MinPathSum();


        int[][] grid = new int[3][3];

        int i = client.minPathSum(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length][grid[0].length];
    }

}
