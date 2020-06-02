package suanfa.may31;

/**
 * @auther eleme
 * @time 2020/5/31 10:16 下午
 * @desc
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea client = new MaxArea();

        client.maxArea(null);
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (i < j) {
            res = Math.min(height[i], height[j]) * (j - i);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
