package lookup;

/**
 * 判断一棵树是不是对称的
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return b(root.left, root.right);
    }
    public boolean b(TreeNode l, TreeNode r){
        if (l == null && r == null)
            return true;
        if (l == null || r == null || l.val != r.val)
            return false;

        return b(l.left, r.right) && b(l.right, r.left);
    }
}
