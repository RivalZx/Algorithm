package lookup;

public class LeetCode450 {
    private int successor(TreeNode root){
        root = root.right;
        while (root != null) root = root.left;
        return root.val;
    }

    private int predecessor(TreeNode root){
        root = root.left;
        while (root != null) root = root.right;
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key > root.val)
            return deleteNode(root.right, key);
        else if (key < root.val)
            return deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left != null) {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            } else {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

}
