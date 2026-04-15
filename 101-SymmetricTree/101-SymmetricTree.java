// Last updated: 4/15/2026, 3:44:14 PM
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
    public boolean isSymmetric(TreeNode root) {
       if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode Ltree, TreeNode Rtree) {
        if (Ltree == null && Rtree == null) return true;
        if (Ltree == null || Rtree == null || Ltree.val != Rtree.val) return false;

        return helper(Ltree.left, Rtree.right) && helper(Ltree.right, Rtree.left);
    }
}