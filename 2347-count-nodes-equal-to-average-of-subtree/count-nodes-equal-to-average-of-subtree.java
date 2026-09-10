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
    int count=0;
    public int[] find(TreeNode root){
        if(root==null){
            return new int[]{0, 0};
        }
        int[] left=find(root.left);
        int[] right=find(root.right);
        int totalsum=left[0]+right[0]+root.val;
        int totalcount=left[1]+right[1]+1;
        if (totalsum / totalcount == root.val) {
            count++;
        }
        return new int[]{totalsum, totalcount};
    }
    public int averageOfSubtree(TreeNode root) {
        find(root);
        return count;
    }
}