package StringQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-10-11 22:02
 **/
public class LeetCode38 {
	
	public static void main(String[] args) {
		LeetCode38 leetCode38 = new LeetCode38();
		String s = leetCode38.countAndSay(4);
		System.out.println(s);
	}
	public String countAndSay(int n) {
		String res = "1";
		for (int i = 1; i <= n - 1; i++) {
			res = countAndSay(res);
		}
		return res;
	}
	
	// 传入一个字符串，返回描述该字符串的字符串
	private String countAndSay(String s) {
		List<List<Character>> list = new ArrayList<>();
		char tempChar = s.toCharArray()[0];
		ArrayList<Character> subList = new ArrayList<>();
		for (char c : s.toCharArray()) {
			if (c == tempChar) {
				subList.add(c);
			} else {
				list.add(subList);
				tempChar = c;
				subList = new ArrayList<>();
				subList.add(c);
			}
		}
		list.add(subList);
		StringBuilder res = new StringBuilder();
		for (List<Character> characters : list) {
			int size = characters.size();
			res.append(size + characters.get(0).toString());
		}
		return res.toString();
	}
}
