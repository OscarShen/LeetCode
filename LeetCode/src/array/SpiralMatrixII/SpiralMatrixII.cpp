#include <vector>
using namespace std;

class Solution {
public:
	vector<vector<int>> generateMatrix(int n) {
		int lastRow, lastCol;
		if (n % 2 == 0) {
			lastRow = n / 2;
			lastCol = n / 2 - 1;
		}
		else {
			lastRow = lastCol = n / 2;
		}
		vector<vector<int>> res(n, vector<int>(n, 0));
		int row = 0, col = 0;
		int loop = 0, cur = 1;
		while (true) {
			for (; col < n - loop; ++col) {
				res[row][col] = cur++;
			}
			--col;
			if (col == lastCol&&row == lastRow)
				break;
			++row;

			for (; row < n - loop; ++row) {
				res[row][col] = cur++;
			}
			--row;
			if (col == lastCol&&row == lastRow)
				break;
			--col;

			for (; col >= loop; --col) {
				res[row][col] = cur++;
			}
			++col;
			if (col == lastCol&&row == lastRow)
				break;
			--row;

			for (; row > loop; --row) {
				res[row][col] = cur++;
			}
			++row;
			if (col == lastCol&&row == lastRow)
				break;
			++col;

			++loop;
		}
		return res;
	}
};