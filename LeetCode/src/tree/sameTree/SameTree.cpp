

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

bool isSameTree(TreeNode* p, TreeNode* q) {
	if (p == nullptr&&q == nullptr)
		return true;
	else if (q == nullptr || p == nullptr)
		return false;
	if (p->val==q->val) {
		return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
	}
	else {
		return false;
	}
}