 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 };

class Solution {
public:
	int sumOfLeftLeaves(TreeNode* root) {
		if (root == nullptr)
			return 0;
		int res = 0;
		addLeaves(root, res, false);
		return res;
	}

	void addLeaves(TreeNode* root, int& res, bool left) {
		if (root->left != nullptr)
			addLeaves(root->left, res, true);
		if(left && root->left==nullptr && root->right==nullptr)
			res += root->val;
		if (root->right != nullptr)
			addLeaves(root->right, res, false);
	}
};