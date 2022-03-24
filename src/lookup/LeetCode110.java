package lookup;

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        return Math.abs((ld - rd)) > 1 ? false : isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node){
        if (node == null)
            return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
