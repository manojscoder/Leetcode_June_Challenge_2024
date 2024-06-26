// Problem link: https://leetcode.com/problems/balance-a-binary-search-tree/description
// Time: O(n)
// Space: O(n)
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> store = new ArrayList<>();
        this.dfs(root, store);
        return this.construct(store, 0, store.size() - 1);
    }

    private void dfs(TreeNode root, List<Integer> store) {
        if(root == null)
            return;
        
        this.dfs(root.left, store);
        store.add(root.val);
        this.dfs(root.right, store);
    }

    private TreeNode construct(List<Integer> store, int low, int high) {
        if(low > high)
            return null;
        
        int mid = (low + high) / 2;

        TreeNode node = new TreeNode(store.get(mid));
        node.left = this.construct(store, low, mid - 1);
        node.right = this.construct(store, mid + 1, high);

        return node;
    }
}
