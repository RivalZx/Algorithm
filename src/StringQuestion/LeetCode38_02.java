package StringQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-10-11 22:02
 **/
public class LeetCode38_02 {
	
	public static void main(String[] args) {
		LeetCode38_02 leetCode38 = new LeetCode38_02();
		String s = leetCode38.countAndSay(4);
		System.out.println(s);
	}
	public String countAndSay(int n) {
		String str = "1";
		if (n == 1) {
			return str;
		}
		for (int i = 2; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			int pos = 0;
			int start = 0;
			while (pos < str.length()) {
				while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
					pos ++;
				}
				sb.append(Integer.toString(pos - start)).append(str.charAt(start));
				start = pos;
			}
			str = sb.toString();
		}
		return str;
	}
	
}
