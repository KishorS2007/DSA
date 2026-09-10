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
    int count = 0;
    private int[] solve(TreeNode root){
        if(root == null) return new int[]{0,0}; // sum , nodes , count

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int avg = (left[0] + right[0] + root.val) / (left[1]+right[1]+1);
        count += (avg == root.val) ? 1 : 0;

        return new int[]{
            left[0] + right[0] + root.val , 
            left[1] + right[1] + 1
        };

    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);

        return count;
    }
}