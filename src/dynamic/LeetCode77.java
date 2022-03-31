package dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * @author: he-zx
 * @create: 2022-03-29 16:02
 **/
public class LeetCode77 {
	
	List<List<Integer>> res = new ArrayList<>();
	
	private void helper(int n, int k, int start, ArrayList<Integer> list){
		if (list.size() == k) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = start; i <= n - (k - list.size()) + 1; i++) {
			list.add(i);
			helper(n, k, i + 1, list);
			list.remove(i);
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
		
		if (n <= 0 || k <= 0 || k > n)
			return res;
		
		ArrayList<Integer> list = new ArrayList<>();
		helper(n, k, 0, list);
		
		return res;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		Deque<Integer> d = new ArrayDeque<>();
		d.add(1);
		d.addLast(2);
		d.addAll(a);
		d.addFirst(6);
		
		
		d.push(9);
		d.pop();
		d.peek();
		d.offer(4);
		
		d.stream().forEach(System.out::println);
		System.out.println();
		System.out.println(d.size());
	}
}
