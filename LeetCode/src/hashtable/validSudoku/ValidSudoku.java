package hashtable.validSudoku;

import java.util.Arrays;

import org.junit.Test;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[] used = new boolean[9];

		// row
		for (int row = 0; row < 9; ++row) {
			Arrays.fill(used, false);
			for (int i = 0; i < 9; ++i) {
				if (used(used, board[row][i]))
					return false;
			}
		}

		// column
		for (int col = 0; col < 9; ++col) {
			Arrays.fill(used, false);
			for (int i = 0; i < 9; ++i) {
				if (used(used, board[i][col]))
					return false;
			}
		}

		// sub matrix
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Arrays.fill(used, false);
				for (int k = 0; k < 9; k++) {
					if (used(used, board[i + k / 3][j + k % 3]))
						return false;
				}
			}
		}
		return true;
	}

	private boolean used(boolean[] used, char digit) {
		if (digit == '.')
			return false;
		int num = digit - '0' - 1;
		if (used[num])
			return true;
		used[num] = true;
		return false;
	}

	@Test
	public void test() {
		char[][] board = { 
				{ '.', '.', '4', '.', '.', '.', '6', '3', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '5', '.', '.', '.', '.', '.', '.', '9', '.' },
				{ '.', '.', '.', '5', '6', '.', '.', '.', '.' }, 
				{ '4', '.', '3', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '7', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '5', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		System.out.println(isValidSudoku(board));
	}
}
