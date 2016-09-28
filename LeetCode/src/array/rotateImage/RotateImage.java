package array.rotateImage;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int n = matrix.length;
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				temp[i][j] = matrix[i][j];
		for (int j = n - 1; j >= 0; --j) {
			for (int i = 0; i < n; ++i) {
				matrix[i][j] = temp[n - 1 - j][i];
			}
		}
	}
}
