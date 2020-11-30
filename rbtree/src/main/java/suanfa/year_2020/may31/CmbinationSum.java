package suanfa.year_2020.may31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther eleme
 * @time 2020/5/31 5:36 下午
 * @desc
 */
public class CmbinationSum {
    public static void main(String[] args) {
        CmbinationSum client = new CmbinationSum();


        List<List<Integer>> res = client.combinationSum(new int[3], 123);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> out = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        helper(candidates, target, 0, out, res);
        return res;
    }

    public void helper(int[] arr, int target, int start, List<Integer> out, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(out));
        }
        for (int i = start; i < arr.length; i++) {
            out.add(arr[i]);
            helper(arr, i + 1, target - arr[i], out, res);
            out.remove(out.size() - 1);
        }
    }

}
