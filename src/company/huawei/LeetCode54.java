package company.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm
 * @description:
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @author: he-zx
 * @create: 2022-04-07 16:40
 **/
public class LeetCode54 {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		
		int l = 0, u = 0;
		int r = matrix.length - 1;
		int d = matrix[0].length - 1;
		
		while (l <= r && u <= d) {
			for (int i = l; i <= r; i++) {
				res.add(matrix[u][i]);
			}
			u ++;
			for (int i = u; i <= d; i++) {
				res.add(matrix[i][r]);
			}
			r --;
			for (int i = r; i >= l; i--) {
				res.add(matrix[r][i]);
			}
			d --;
			for (int i = d; i >= u; i--) {
				res.add(matrix[i][l]);
			}
			l ++;
		}
		return res;
	}
}
