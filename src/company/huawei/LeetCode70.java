package company.huawei;

/**
 * @program: Algorithm
 * @description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author: he-zx
 * @create: 2022-04-05 16:52
 **/
public class LeetCode70 {
	public int climbStairs(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		
		int[] temp = new int[n + 1];
		temp[1] = 1;
		temp[2] = 2;
		for (int i = 3; i <= n; i++) {
			temp[i] = temp[i - 1] + temp[i - 2];
		}
		return temp[n];
	}
	
	public int climbStairs2(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		int a = 1, b = 2, temp;
		for (int i = 3; i <= n; i++) {
			temp = a;
			a = b;
			b = a + temp;
		}
		return b;
	}
}
