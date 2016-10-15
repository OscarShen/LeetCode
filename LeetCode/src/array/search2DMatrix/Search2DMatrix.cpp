#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
	bool searchMatrix(vector<vector<int>>& matrix, int target) {
		int&& row = searchRow(matrix, target, 0, matrix.size() - 1);
		return findElement(matrix[row], target, 0, matrix[row].size() - 1);
	}
	
	int searchRow(vector<vector<int>>& matrix, int target, int left, int right) {
		if (left >= right)
			return left;
		int mid = (left + right) / 2;
		if (target < matrix[mid][0])
			return searchRow(matrix, target, left, mid - 1);
		else if (target >= matrix[mid][0] && target < matrix[mid + 1][0])
			return mid;
		else
			return searchRow(matrix, target, mid + 1, right);
	}

	bool findElement(vector<int>& row, int target, int left, int right) {
		if (left > right)
			return false;
		int mid = (left + right) / 2;
		if (target < row[mid])
			return findElement(row, target, left, mid - 1);
		else if (target > row[mid])
			return findElement(row, target, mid + 1, right);
		else
			return true;
	}
};