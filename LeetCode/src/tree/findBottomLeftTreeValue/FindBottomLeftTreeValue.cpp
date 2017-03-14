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
    int value = 0, height = 0; // ������ȱ�������������ô��һ��height����depthʱ����ȡ�����е�һ��ֵ��ʱ��
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