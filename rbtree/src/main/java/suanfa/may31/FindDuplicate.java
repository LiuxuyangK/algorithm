package suanfa.may31;

/**
 * @auther eleme
 * @time 2020/5/31 5:36 下午
 * @desc
 */
public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate client = new FindDuplicate();

//        client.findDuplicate();
        System.out.println();
    }

    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < mid; i++) {
                if (nums[i] <= mid) ++count;
            }

            if (count < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
