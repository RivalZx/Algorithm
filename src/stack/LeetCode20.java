package stack;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Algorithm
 * @description:有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @author: he-zx
 * @create: 2022-04-06 15:21
 **/
public class LeetCode20 {
	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				char top = stack.pop();
				if (c == '(' && top != ')') {
					return false;
				}
				if (c == '[' && top != ']') {
					return false;
				}
				if (c == '{' && top != '}') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
