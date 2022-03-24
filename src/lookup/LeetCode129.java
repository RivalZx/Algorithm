package lookup;

public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int sum) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return sum * 10 + node.val;
        return helper(node.left, sum * 10 + node.val) + helper(node.right, sum * 10 + node.val);
    }
}
