/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private static TreeNode target;
    private static TreeNode solve(TreeNode original , TreeNode clone){
        if(original == null) return null;
        if(original == target) return clone;

        TreeNode left = solve(original.left,clone.left);
        if(left != null) return left;
        
        TreeNode right = solve(original.right,clone.right);
        return right;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target; 
        return solve(original , cloned);
    }
}