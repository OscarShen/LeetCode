#include <vector>
using namespace std;

class Solution {
public:
	void setZeroes(vector<vector<int>>& matrix) {
		bool rowZero = false, colZero = false;
		int m = matrix.size();
		if (m == 0)
			return;
		int n = matrix[0].size();
		if (n == 0)
			return;
		for (int i = 0; i < m; ++i)
			if (matrix[i][0] == 0) {
				colZero = true;
				break;
			}

		for (int j = 0; j < n; ++j)
			if (matrix[0][j] == 0) {
				rowZero = true;
				break;
			}

		for (int i = 1; i < m; ++i)
			for (int j = 1; j < n; ++j)
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}

		for (int i = 1; i < m; ++i) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; ++j)
					matrix[i][j] = 0;
			}
		}

		for (int j = 1; j < n; ++j) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < m; ++i)
					matrix[i][j] = 0;
			}
		}

		if (rowZero) {
			for (int j = 0; j < n; ++j)
				matrix[0][j] = 0;
		}
		if (colZero) {
			for (int i = 0; i < m; ++i)
				matrix[i][0] = 0;
		}
	}
};


int main() {
	vector<vector<int>> matrix{
		{0, 0, 0, 5}, 
		{4, 3, 1, 4}, 
		{0, 1, 1, 4}, 
		{1, 2, 1, 3}, 
		{0, 0, 1, 1}}
	;
	Solution().setZeroes(matrix);
}