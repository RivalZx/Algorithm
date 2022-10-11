package StringQuestion;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-10-11 22:35
 **/
public class LeetCode415 {
	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0) {
			int n = i >= 0 ? num1.charAt(i) - '0' : 0;
			int m = j >= 0 ? num2.charAt(j) - '0' : 0;
			
			int sum = n + m + carry;
			carry = sum / 10;
			sb.append(sum % 10);
			i --;
			j --;
		}
		if (carry == 1) {
			sb.append("1");
		}
		return sb.reverse().toString();
	}
}
