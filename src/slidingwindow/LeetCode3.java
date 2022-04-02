package slidingwindow;

import java.util.HashMap;

/**
 * @program: Algorithm
 * @description: 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: he-zx
 * @create: 2022-04-02 11:46
 **/
public class LeetCode3 {
	public int lengthOfLongestSubstring(String s) {
		int[] freq = new int[256];
		int l = 0;
		int r = -1;
		int res = 0;
		
		while (l < s.length()) {
			if (r + 1 < s.length() && freq[(int)s.charAt(r + 1)] == 0) {
				r ++;
				freq[(int)s.charAt(r)] ++;
			} else {
				freq[(int)s.charAt(l)] --;
				l ++;
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
