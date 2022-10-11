package StringQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-10-11 21:49
 **/
public class LeetCode71 {
	public String simplifyPath(String path) {
		Deque<String> stack = new ArrayDeque<>();
		String[] names = path.split("/");
		for (String name : names) {
			if ("..".equals(name)) {
				if (!stack.isEmpty()) {
					stack.pollLast();
				}
			} else if (name.length() > 0 && !".".equals(name)) {
				stack.offerLast(name);
			}
		}
		
		StringBuilder ans = new StringBuilder();
		if (stack.isEmpty()) {
			ans.append("/");
		} else {
			while (!stack.isEmpty()) {
				ans.append("/");
				ans.append(stack.pollFirst());
			}
		}
		return ans.toString();
	}
}
