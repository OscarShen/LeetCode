struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode *pre = nullptr;

bool isValidBST(TreeNode* root) {
	if (root == nullptr)
		return true;
	if (!isValidBST(root->left))
		return false;
	if (pre != nullptr&&root->val <= pre->val) {
		return false;
	}
	pre = root;
	return isValidBST(root->right);
}