package suanfa.march3rd;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @auther eleme
 * @time 2020/6/3 10:56 上午
 * @desc
 */
public class CanPartition {

    public static void main(String[] args) {

    }

    /**
     * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92.md#1-%E5%88%92%E5%88%86%E6%95%B0%E7%BB%84%E4%B8%BA%E5%92%8C%E7%9B%B8%E7%AD%89%E7%9A%84%E4%B8%A4%E9%83%A8%E5%88%86
     * <p>
     * https://blog.csdn.net/qq_26410101/article/details/80806463
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean res = false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int m = nums.length;
        sum = sum / 2;

        //创建dp数组
        boolean[][] dp = new boolean[m + 1][sum + 1];


        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[m][sum];
    }

    /**
     * 从二维变成一维
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        //转化成一维数组，一定要倒着来
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }

}
