#include <vector>
#include <stack>
using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
class Solution {
public:
	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> res;
		TreeNode* p = root;
		stack<TreeNode*> s;
		while (!s.empty() || p)
		{
			if (p)
			{
				s.push(p);
				p = p->left;
			}
			else
			{
				p = s.top();
				s.pop();
				res.push_back(p->val);
				p = p->right;
			}
		}
		return res;
	}
};

void main() {
	auto t1 = new TreeNode(1);
	auto t2 = new TreeNode(2);
	auto t3 = new TreeNode(3);
	t1->right = t2;
	t2->left = t3;
	auto res = (new Solution())->inorderTraversal(t1);
}