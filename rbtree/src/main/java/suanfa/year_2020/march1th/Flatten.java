package suanfa.year_2020.march1th;

import suanfa.year_2020.may31.TreeNode;

/**
 * @auther eleme
 * @time 2020/6/1 10:56 下午
 * @desc
 */
public class Flatten {

    public static void main(String[] args) {
        Flatten client = new Flatten();



    }

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode p = cur.left;
                while (p != null && p.right != null) {
                    p = p.right;
                }
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
