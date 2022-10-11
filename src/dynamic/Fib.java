package dynamic;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-10-08 20:50
 **/
public class Fib {
	private static int[] num;
	public static void main(String[] args) {
		final int n = 40;
		num = new int[n + 1];
		for (int i = 0; i < num.length; i++) {
			num[i] = -1;
		}
		
		long start = System.currentTimeMillis();
		System.out.println("num: " + fib2(n));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (num[n] == -1)
			num[n] = fib(n - 1) + fib(n - 2);
		return num[n];
	}
	
	public static int fib2(int n) {
		int[] num = new int[n + 1];
		num[0] = 0;
		num[1] = 1;
		for (int i = 2; i <= n; i++) {
			num[i] = num[i - 1] + num[i - 2];
		}
		return num[n];
	}
}
