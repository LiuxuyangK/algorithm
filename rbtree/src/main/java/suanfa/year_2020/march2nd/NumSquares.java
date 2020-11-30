package suanfa.year_2020.march2nd;

/**
 * @auther eleme
 * @time 2020/6/2 11:41 下午
 * @desc
 */
public class NumSquares {

    public static void main(String[] args) {

    }

    /**
     * https://github.com/grandyang/leetcode/issues/279
     *
     * @param n
     * @return
     */
    public int numSquares1(int n) {

        int num = 2;
        int res = n;

        while (num * num <= n) {
            int a = n / (num * num);
            int b = n % (num * num);

            res = Math.min(res, a + numSquares1(b));
            num++;
        }

        return res;
    }

}
