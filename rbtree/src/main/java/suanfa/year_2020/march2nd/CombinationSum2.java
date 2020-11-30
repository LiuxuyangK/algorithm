package suanfa.year_2020.march2nd;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther eleme
 * @time 2020/6/2 10:49 上午
 * @desc https://leetcode-cn.com/problems/combination-sum-ii/
 * <p>
 * 【combinationSum】https://github.com/grandyang/leetcode/issues/39：数组中的数字可以重复使用
 * 【combinationSum2】https://github.com/grandyang/leetcode/issues/40：数组中的数字不可以重复使用
 * <p>
 * 【cyc2018整理的】https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E6%90%9C%E7%B4%A2.md#8-%E7%BB%84%E5%90%88%E6%B1%82%E5%92%8C
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 client = new CombinationSum2();
//        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int[] arr = {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = client.combinationSum2(arr, target);

        System.out.println(JSONObject.toJSONString(lists));
    }

    /**
     * 首先在递归的 for 循环里加上 if (i > start && num[i] == num[i - 1]) continue; 这样可以防止 res 中出现重复项，
     * 然后就在递归调用 helper 里面的参数换成 i+1
     * <p>
     * 想不明白我和这道题写的有什么不一样的。https://github.com/grandyang/leetcode/issues/40
     * 但是这道题目就能运行正确，我写的java版本就不行
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        combinationSum2Helper(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    public void combinationSum2Helper(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> out) {

        if (target < 0) {
            return;
        }
        if (0 == target) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            out.add(candidates[i]);
            combinationSum2Helper(candidates, i + 1, target - candidates[i], res, out);
            out.remove(out.size() - 1);
        }
    }
}
