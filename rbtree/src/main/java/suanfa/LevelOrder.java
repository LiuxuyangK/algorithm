package suanfa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

///
//  @auther eleme
//  @time 2020/5/31 5:36 下午
//  @desc
// /
public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder client = new LevelOrder();

//        client.findDuplicate();
        System.out.println();
    }

    

    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sub = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sub.add(poll.val);

                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            res.add(sub);
        }
        return res;
    }
}
