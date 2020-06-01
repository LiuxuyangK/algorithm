package suanfa;

import java.util.HashMap;

/**
 * @auther eleme
 * @time 2020/5/31 10:25 下午
 * @desc
 */
public class Rob3 {

    public HashMap<TreeNode,Integer> map = new HashMap();

    public static void main(String[] args) {

    }


    public int rob(TreeNode root) {
        if(root  == null){
            return 0;
        }

        if (map.get(root) != null) {
            return map.get(root);
        }
        int res = root.val;
        if(root.left != null){
            res += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            res += rob(root.right.left) + rob(root.right.right);
        }

        int res2 = rob(root.left) + rob(root.right);
        int max = Math.max(res, res2);
        map.put(root,max);
        return max;
    }
}
