package lookup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode230 {
    List<Integer> res = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return res.get(k - 1);
    }

    private void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
