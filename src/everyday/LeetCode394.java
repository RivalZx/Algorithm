package everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Algorithm
 * @description: 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 
 * @author: he-zx
 * @create: 2022-04-07 13:27
 **/
public class LeetCode394 {
	public String decodeString(String s) {
		Deque<String> str = new ArrayDeque<>();
		Deque<Integer> num = new ArrayDeque<>();
		StringBuilder res = new StringBuilder();
		int multi = 0;
		char[] chars = s.toCharArray();
		for (Character cur : s.toCharArray()) {
			if (cur == '[') {
				num.push(multi);
				str.push(res.toString());
				multi = 0;
				res = new StringBuilder();
			} else if (cur == ']') {
				StringBuilder t = new StringBuilder();
				int cur_num = num.pop();
				for (int j = 0; j < cur_num; j++) {
					t.append(res);
				}
				res = new StringBuilder(str.pop() + t);
			} else if (cur >= '0' && cur <= '9') {
				multi = multi * 10 + (cur - '0');
			} else {
				res.append(cur);
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		LeetCode394 l = new LeetCode394();
		System.out.println(l.decodeString("3[a]2[bc]"));
	}
}
