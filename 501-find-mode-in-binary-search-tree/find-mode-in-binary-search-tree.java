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
    Map<Integer,Integer> map = new HashMap<>();
    int maxFreq = 0;
    private void traverse(TreeNode node){
        if(node == null) return;
        map.put(node.val,map.getOrDefault(node.val,0)+1);
        maxFreq = Math.max(maxFreq,map.get(node.val));

        traverse(node.left);
        traverse(node.right);
    }

    public int[] findMode(TreeNode root) {
        traverse(root);
        int count = 0;
        for(int i : map.values()){
            if(i == maxFreq) count++;
        }

        int[] ans = new int[count];
        int x = 0;
        for(int i : map.keySet()){
            if(map.get(i) == maxFreq) ans[x++] = i;
        }

        return ans;
    }
}