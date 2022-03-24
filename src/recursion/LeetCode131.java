package recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0)
            return res;
        Deque<String> path = new ArrayDeque<>();
        helper(s.toCharArray(), 0, len, path, res);
        return res;

    }

    private void helper(char[] sChar, int index, int len, Deque<String> path, List<List<String>> res){
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (!checkPalindrome(sChar, index, i))
                continue;
            path.addLast(new String(sChar, index, i - index + 1));
            helper(sChar, i + 1, len, path, res);
            path.removeLast();
        }
    }



    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
