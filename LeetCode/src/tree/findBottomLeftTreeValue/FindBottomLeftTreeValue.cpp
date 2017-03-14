/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int value = 0, height = 0; // 如果首先遍历左子树，那么第一次height等于depth时就是取到该行第一个值得时候
    int findBottomLeftValue(TreeNode* root) {
        breadth_first(root, 1);
        return value;
    }
    
    void breadth_first(TreeNode* node, int depth){
        if(height < depth){
            value = node->val;
            height = depth;
        }
        if(node->left != nullptr){breadth_first(node->left, depth + 1);}
        if(node->right != nullptr){breadth_first(node->right, depth + 1);}
    }
};