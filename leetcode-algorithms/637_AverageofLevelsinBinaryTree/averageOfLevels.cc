/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> result;
        queue<TreeNode*> queue;
        queue.push(root);

        while (!queue.empty()) {
            int n = queue.size();
            double sum = 0.0;
            for (int i = 0; i < n ; i++) {
                TreeNode* current = queue.front();
                queue.pop();
                sum += current->val;
                if (current->left != nullptr) {
                    queue.push(current->left);
                }
                if (current->right != nullptr) {
                    queue.push(current->right);
                }
            }

            result.push_back(sum / n);
        }

        return result;
    }
};
