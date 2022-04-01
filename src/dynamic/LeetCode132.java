package dynamic;

/**
 * @program: Algorithm
 * @description: 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 * @author: he-zx
 * @create: 2022-04-01 20:03
 **/
public class LeetCode132 {
	public int minCut(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		int len = s.length();
		char[] cs = s.toCharArray();
		boolean[][] b = new boolean[len + 1][len + 1];
		
		//第一步：b[l][r]记录 l 到 r是否为回文字符串
		for (int r = 1; r <= len; r++) {
			for (int l = r; l >= 1; l--) {
				if (l == r) {
					b[l][r] = true;
				} else {
					if (cs[l - 1] == cs[r - 1]) {
						if (r - l == 1 || b[l + 1][r - 1]) {
							b[l][r] = true;
						}
					}
				}
			}
		}
		
		//第二步：找出1 - r使用的最小切割次数
		int[] f = new int[len + 1];
		for (int r = 1; r <= len; r++) {
			if (b[1][r]) {
				f[r] = 0;
			} else {
				f[r] = r - 1;
				for (int l = 1; l <= r; l++) {
					if (b[l][r]) {
						f[r] = Math.min(f[r], f[l - 1] + 1);
					}
				}
			}
		}
		
		return f[len];
	}
}
