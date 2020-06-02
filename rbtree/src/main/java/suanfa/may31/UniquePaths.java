package suanfa.may31;

/**
 * @auther eleme
 * @time 2020/5/31 5:36 下午
 * @desc
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths client = new UniquePaths();


        int[][] grid = new int[3][3];

        int i = client.uniquePaths(3,2);
        System.out.println(i);
    }

    public int uniquePaths(int m, int n) {
        int[]dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
