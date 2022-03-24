package lookup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return null;

        List<String> res = new ArrayList<String>();
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> list = binaryTreePaths(root.left);
        for (int i = 0; i < list.size(); i++)
            res.add(root.val + "->" + list.get(i));

        List<String> list1 = binaryTreePaths(root.right);
        for (int i = 0; i < list1.size(); i++)
            res.add(root.val + "->" + list1.get(i));

        return res;
    }
}
