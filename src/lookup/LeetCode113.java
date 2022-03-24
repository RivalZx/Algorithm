package lookup;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode113 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum);
        return res;
    }
    private void helper(TreeNode node, int target){
        if (node == null)
            return;

        path.offerLast(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0)
            res.add(new LinkedList<Integer>(path));

        helper(node.left, target);
        helper(node.right, target);
        path.pollLast();
    }
}
