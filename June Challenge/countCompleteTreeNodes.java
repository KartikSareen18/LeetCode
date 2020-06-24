// Count Complete Tree Nodes

// Given a complete binary tree, count the number of nodes.

// Note:

// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Example:

// Input: 
//     1
//    / \
//   2   3
//  / \  /
// 4  5 6

// Output: 6

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
    //        O(N)
    //     public int countNodes(TreeNode root) {
    //         if(root==null)
    //             return 0;
    //         return countNodes(root.left)+countNodes(root.right)+1;
            
    //     }
        
    //    O(logN * logN)
        public int countNodes(TreeNode root) {
            if(root==null)
                return 0;
            int left=0,right=0;
            TreeNode curr=root;
            while(curr!=null){
                left++;
                curr=curr.left;
            }
            curr=root;
            while(curr!=null){
                right++;
                curr=curr.right;
            }
            if(left==right)
                return (int)Math.pow(2,left)-1;
            return countNodes(root.left)+countNodes(root.right)+1;   
        }
    }