package suanfa.march1th;

/**
 * @auther eleme
 * @time 2020/6/1 11:48 下午
 * @desc
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        FindTargetSumWays client = new FindTargetSumWays();


    }

    public int findTargetSumWays(int[] nums, int S) {
        int [] res = new int[1];
        findTargetSumWays(nums,S,0,res);
        return res[0];
    }

    public void findTargetSumWays(int[] nums, int S, int start, int[] res) {
        if (start > nums.length) {
            if (S == 0) {
                res[0]++;
                return;
            }
        }

        findTargetSumWays(nums, S - nums[start], start + 1, res);
        findTargetSumWays(nums, S + nums[start], start + 1, res);

    }
}
