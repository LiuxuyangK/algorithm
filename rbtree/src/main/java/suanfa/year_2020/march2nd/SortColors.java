package suanfa.year_2020.march2nd;

/**
 * @auther eleme
 * @time 2020/6/3 12:06 上午
 * @desc https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    /**
     * 三色排序问题：[2,0,2,1,1,0] -》 [0,0,1,1,2,2]
     * 题目中还要让只遍历一次数组来求解，那么我需要用双指针来做，分别从原数组的首尾往中心移动。
     * <p>
     * - 定义red指针指向开头位置，blue指针指向末尾位置。
     * <p>
     * 1.   从头开始遍历原数组，如果遇到0，则交换该值和red指针指向的值，并将red指针后移一位。
     * 2.   若遇到2，则交换该值和blue指针指向的值，并将blue指针前移一位。若遇到1，则继续遍历。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for (int i = 0; i <= blue; ++i) {

            //正常后面会有i++去帮忙更新i的
            if (nums[i] == 0) {
                swap(nums, i, red++);
            } else if (nums[i] == 2) {

                //i--，主要是为了不想更新i的值，因为可能换过来的，是一个0，也可能是一个1
                swap(nums, i--, blue--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1, cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur++, left++);
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
            } else {
                ++cur;
            }
        }
    }


    public void sort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(nums, i, right--);
            } else if (nums[i] == 2) {
                //从后面换过来的，不一定是对的。前面都是一脚一脚淌出来的，肯定是对的
                swap(nums, i--, right--);
            }
        }
    }
}
