#include <vector>
using namespace std;

#define MIN(A,B) ((A)<(B)?(A):(B))

int minPathSum(vector<vector<int>>& grid) {
	if (grid.size() == 0)
		return 0;
	for (int i = 1; i < grid[0].size(); ++i) {
		grid[0][i] += grid[0][i - 1];
	}

	for (int j = 1; j < grid.size(); ++j) {
		grid[j][0] += grid[j - 1][0];
		for (int k = 1; k < grid[0].size(); ++k) {
			grid[j][k] += MIN(grid[j - 1][k], grid[j][k - 1]);
		}
	}

	return grid[grid.size() - 1][grid[0].size() - 1];
}