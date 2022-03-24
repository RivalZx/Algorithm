package lookup;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode437 {
    //在以root为根结点的二叉树中，寻找和为sum的路径，返回这样的路径的个数
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int res = findPath(root, targetSum);
        res += pathSum(root.left, targetSum - root.val);
        res += pathSum(root.right, targetSum - root.val);
        return res;
    }

    //在以node为根结点的二叉树中，寻找包含node的路径，和为num
    //返回这样的路径个数
    private int findPath(TreeNode node, int num){
        if (node == null)
            return 0;
        int res = 0;
        if (node.val == num)
            res += 1;
        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);
        return res;
    }
}
