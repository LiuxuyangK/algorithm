package suanfa.may31;

import java.util.*;

///
//  @auther eleme
//  @time 2020/5/31 4:17 下午
//  @desc
// /
public class Test {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(1);
//        TreeNode root2 = new TreeNode(2);
//        root1.right = root2;
//        kthSmallest(root1,2);

        Test client = new Test();

//        int[] arr = {3, 2, 1, 5, 4, 6};


        int[] arr = {3,2,3,1,2,4,5,5,6};
        int kthLargest = client.findKthLargest(arr, 4);
        System.out.println(kthLargest);
    }

    public static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack();
        //stack.push(root);

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            root = cur.right;
        }
        return 0;
    }

    public int findKthLargest(int[] nums, int k) {
        //排序，优先队列，快排
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int index_t = nums.length - k;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == index_t) {
                return nums[pivot];
            } else if (pivot > index_t) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return nums[left];
    }

    public int partition(int[] arr, int l, int r) {
        int temp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= temp) {
                r--;
            }

            arr[l] = arr[r];
            while (l < r && arr[l] <= temp) {
                l++;
            }

            arr[r] = arr[l];
        }

        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[l] = temp;
        return l; // 返回tmp的正确位置
    }
}
