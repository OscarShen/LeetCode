package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 2, 3 } };
		List<Integer> list = new SpiralMatrix().spiralOrder(matrix);
		for (int temp : list) {
			System.out.print(temp + " ");
		}
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null) {
			return null;
		}
		if (matrix.length == 0) {
			return new ArrayList<>();
		}
		int left = 0;
		int right = matrix[0].length - 1;
		int up = 0;
		int down = matrix.length - 1;
		int n = matrix.length * matrix[0].length;
		int cur = 0;
		List<Integer> res = new ArrayList<>();

		while (left <= right && up <= down) {
			for (int i = left; i <= right; i++) {
				res.add(matrix[up][i]);
				cur++;
				if (n == cur) {
					return res;
				}
				if (i == right) {
					up++;
					break;
				}
			}

			for (int j = up; j <= down; j++) {
				res.add(matrix[j][right]);
				cur++;
				if (n == cur) {
					return res;
				}
				if (j == down) {
					right--;
					break;
				}
			}

			for (int k = right; k >= left; k--) {
				res.add(matrix[down][k]);
				cur++;
				if (n == cur) {
					return res;
				}
				if (k == left) {
					down--;
					break;
				}
			}

			for (int l = down; l >= up; l--) {
				res.add(matrix[l][left]);
				cur++;
				if (n == cur) {
					return res;
				}
				if (l == up) {
					left++;
					break;
				}
			}
		}

		return res;
	}
}
