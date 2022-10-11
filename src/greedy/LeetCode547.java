package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Algorithm
 * @description:
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 * @author: he-zx
 * @create: 2022-09-01 22:29
 **/
public class LeetCode547 {
	public int findCircleNum(int[][] isConnected) {
		int res = 0;
		int cities = isConnected.length;
		boolean[] visited = new boolean[cities];
		
		for (int i = 0; i < cities; i++) {
			if (!visited[i]) {
				dfs(isConnected, visited, cities, i);
				res ++;
			}
		}
		return res;
//		UnionFind uf = new UnionFind();
//		for (int i = 0; i < isConnected.length; i++) {
//			uf.add(i);
//			for (int j = 0; j < i; j++) {
//				if (isConnected[i][j] == 1) {
//					uf.merge(i, j);
//				}
//			}
//		}
//
//		return uf.getNumOfSets();
	}
	
	public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
		for (int j = 0; j < cities; j++) {
			if (isConnected[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(isConnected, visited, cities, j);
			}
		}
	}
	
	
}

class UnionFind {
	private Map<Integer, Integer> father;
	private int numOfSets;
	
	public UnionFind() {
		father = new HashMap<>();
		numOfSets = 0;
	}
	
	public void add(int x) {
		if (!father.containsKey(x)) {
			father.put(x, null);
			numOfSets ++;
		}
	}
	
	// x y 相连
	public void merge(int x, int y) {
		int root1 = find(x);
		int root2 = find(y);
		
		if (root1 != root2) {
			father.put(root1, root2);
			numOfSets --;
		}
	}
	
	// 查询x的根
	public int find(int x) {
		int root = x;
		
		while (father.get(root) != null) {
			root = father.get(root);
		}
		
		// 将x放到第二层
		while (x != root) {
			int original_father = father.get(x);
			father.put(x, root);
			x = original_father;
		}
		return root;
	}
	
	public boolean isConnected(int x, int y) {
		return find(x) == find(y);
	}

	public int getNumOfSets() {
		return numOfSets;
	}
}