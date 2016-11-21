#include <vector>

using namespace std;

int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
	if (obstacleGrid.size() == 0)
		return 0;
	int m = obstacleGrid.size(), n = obstacleGrid[0].size();
	vector<int> tmp(n, 0);
	bool isObs = false;
	for (int j = 0; j < n; ++j) {
		if (obstacleGrid[0][j] == 1)
			isObs = true;
		if (!isObs)
			tmp[j] = 1;
	}
	for (int i = 1; i < m; ++i) {
		if (obstacleGrid[i][0] == 1 || obstacleGrid[i - 1][0] == 1) {
			tmp[0] = 0;
		}
		for (int j = 1; j < n; ++j) {
			if (obstacleGrid[i][j] == 1) { // obstacle
				tmp[j] = 0;
				continue;
			}
			else if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1) { // obstacle in the left and up
				tmp[j] = 0;
			}
			else if (obstacleGrid[i][j - 1] == 1) { // obstacle in the left
				; // do not change value
			}
			else if (obstacleGrid[i - 1][j] == 1) { // obstacle in the up
				tmp[j] = tmp[j - 1];
			}
			else {
				tmp[j] += tmp[j - 1];
			}
		}
	}
	return tmp[n - 1];
}