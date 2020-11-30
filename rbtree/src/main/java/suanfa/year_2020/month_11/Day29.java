package suanfa.year_2020.month_11;

import java.util.HashMap;
import java.util.Map;

public class Day29 {
    /**
     * https://leetcode-cn.com/problems/two-sum/
     * 两数之和：https://www.cnblogs.com/grandyang/p/4130379.html
     * 两数之和2-输入数组有序：https://www.cnblogs.com/grandyang/p/5185815.html
     * 两数之和3：https://www.cnblogs.com/grandyang/p/5184143.html
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.putIfAbsent(num, i);
        }
        return null;
    }

    /**
     * 两数之和2：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     * 二分解法
     * 双指针解法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }


    /**
     * 因为一定有解，而且数组是有序的，那么第一个数字肯定要小于目标值target，那么我们每次用二分法来搜索target - numbers[i]即可
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2_2(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int left = i;
            int right = numbers.length - 1;
            int t = target - numbers[left];

            while (left < right) {
                int mid = (left + right) / 2;
                if (numbers[mid] == t) {
                    return new int[]{left + 1, mid + 1};
                }
                if(numbers[mid] < t){
                    left = mid;
                }else{
                    right = mid;
                }
            }
        }

        return null;
    }
}
