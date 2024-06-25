// Problem link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description
// Time: O(n)
// Space: O(1)
class Solution {

    public TreeNode bstToGst(TreeNode root) {
        int[] currSum = new int[1];
        dfs(root, currSum);
        return root;
    }

    private void dfs(TreeNode root, int[] currSum) {
        if(root == null)
            return;
        
        dfs(root.right, currSum);
        currSum[0] += root.val;
        root.val = currSum[0];
        dfs(root.left, currSum);
    }   
}
