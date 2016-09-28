#include <vector>

using namespace std;

void rotate(vector<vector<int>>& matrix) {
	int n = matrix.size();
	auto temp = matrix;
	for (int j = n - 1; j >= 0; --j) {
		for (int i = 0; i < n; ++i) {
			temp[i][j] = matrix[n - 1 - j][i];
		}
	}
	matrix = temp;
}