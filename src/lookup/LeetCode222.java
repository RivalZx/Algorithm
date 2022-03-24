package lookup;

public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if (ld == rd)
            return (1 << ld) + countNodes(root.right);
        else
            return (1 << rd) + countNodes(root.left);

    }

    public int getDepth(TreeNode node){
        int depth = 0;
        while (node != null) {
            depth ++;
            node = node.left;
        }
        return depth;
    }
}
