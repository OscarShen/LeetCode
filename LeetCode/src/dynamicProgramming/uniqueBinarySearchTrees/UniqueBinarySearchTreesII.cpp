#include <vector>

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

std::vector<TreeNode*> createTree(int start, int end) {
	std::vector<TreeNode*> result;
	if (start > end) {
		result.push_back(nullptr);
		return result;
	}
	for (int k = start; k <= end; ++k) {
		std::vector<TreeNode*> &&left = createTree(start, k - 1);
		std::vector<TreeNode*> &&right = createTree(k + 1, end);
		for (int i = 0; i < left.size(); ++i) {
			for (int j = 0; j < right.size(); ++j) {
				TreeNode *root = new TreeNode(k);
				root->left = left[i];
				root->right = right[j];
				result.push_back(root);
			}
		}
	}
	return result;
}

std::vector<TreeNode*> generateTrees(int n) {
	if (n == 0)
		return std::vector<TreeNode*>();
	return createTree(1, n);
}