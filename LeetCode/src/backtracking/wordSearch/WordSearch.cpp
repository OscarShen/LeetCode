#include <vector>
#include <string>
using namespace std;

bool isOut(vector<vector<char>> &board, int i, int j) {
	if (i >= 0 && i < board.size() && j >= 0 && j < board[0].size())
		return false;
	return true;
}

bool backTrace(vector<vector<char>> &board, const string &word, int k, int m, int n, vector<vector<bool>> &flag) {
	if (k == word.size())
		return true;
	if (!isOut(board, m - 1, n) && board[m - 1][n] == word[k] && !flag[m - 1][n]) {
		flag[m - 1][n] = true;
		if (backTrace(board, word, k + 1, m - 1, n, flag))
			return true;
		flag[m - 1][n] = false;
	}
	if (!isOut(board, m + 1, n) && board[m + 1][n] == word[k] && !flag[m + 1][n]) {
		flag[m + 1][n] = true;
		if (backTrace(board, word, k + 1, m + 1, n, flag))
			return true;
		flag[m + 1][n] = false;
	}
	if (!isOut(board, m, n - 1) && board[m][n - 1] == word[k] && !flag[m][n - 1]) {
		flag[m][n - 1] = true;
		if (backTrace(board, word, k + 1, m, n - 1, flag))
			return true;
		flag[m][n - 1] = false;
	}
	if (!isOut(board, m, n + 1) && board[m][n + 1] == word[k] && !flag[m][n + 1]) {
		flag[m][n + 1] = true;
		if (backTrace(board, word, k + 1, m, n + 1, flag))
			return true;
		flag[m][n + 1] = false;
	}
	return false;
}


bool exist(vector<vector<char>>& board, string word) {
	if (word == "")
		return true;
	if (board.size() == 0)
		return false;
	int m = board.size(), n = board[0].size();
	vector<bool> tmp(n, false);
	vector<vector<bool>> flag(m, tmp);
	char ch = word[0];
	for (int i = 0; i < m; ++i) {
		for (int j = 0; j < n; ++j) {
			if (board[i][j] == ch) {
				flag[i][j] = true;
				if (backTrace(board, word, 1, i, j, flag))
					return true;
				flag[i][j] = false;
			}
		}
	}
	return false;
}

int main() {
	vector<vector<char>> board{
		{'A','B','C','E'},
		{'S','F','C','S' },
		{'A', 'D', 'E', 'E'}
	};
	bool res = exist(board, "ABCB");
}