// Last updated: 4/15/2026, 3:42:37 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {

        totalSum = getTotalSum(root);
        getSubtreeSum(root);
        return (int)(maxProduct % MOD);
    }
    
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }
   
    private long getSubtreeSum(TreeNode node) {
        if (node == null) return 0;
        long left = getSubtreeSum(node.left);
        long right = getSubtreeSum(node.right);
        long subTreeSum = left + right + node.val;
        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subTreeSum;
    }    
    
}