#include <vector>
#include <iostream>
using std::vector;
using std::fill;

bool is_used(bool used[], char& c) {
	if (c == '.')
		return false;
	int num = c - '0' - 1;
	if (used[num])
		return true;
	used[num] = true;
	return false;
}

bool isValidSudoku(vector<vector<char>>& board) {
	bool used[9];

	for (int i = 0; i < 9; ++i) {
		//row
		fill(used, used + 9, false);
		for (int j = 0; j < 9; ++j) {
			if (is_used(used, board[i][j]))
				return false;
		}

		//col
		fill(used, used + 9, false);
		for (int k = 0; k < 0; ++k) {
			if (is_used(used, board[k][i]))
				return false;
		}
	}

	for (int i = 0; i < 9; i += 3) {
		for (int j = 0; j < 9; j += 3) {
			fill(used, used + 9, false);
			for (int k = 0; k < 9; ++k) {
				if (is_used(used, board[i + k / 3][j + k % 3]))
					return false;
			}
		}
	}
	return true;
}