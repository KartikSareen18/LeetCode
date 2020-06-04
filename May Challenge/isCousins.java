// Cousins in Binary Tree
// In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

// Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

// We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

// Return true if and only if the nodes corresponding to the values x and y are cousins.

 

// Example 1:


// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false
// Example 2:


// Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: true
// Example 3:



// Input: root = [1,2,3,null,4], x = 2, y = 3
// Output: false
 

// Constraints:

// The number of nodes in the tree will be between 2 and 100.
// Each node has a unique integer value from 1 to 100.


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

public class Pair{
    TreeNode parent;
    int height;
}
class Solution {
    public Pair getDepthAndParent(TreeNode root,int x,int depth){
        if(root==null){
            Pair p=new Pair();
            p.parent=null;
            p.height=-1;
            return p;
        }
        if((root.left!=null && root.left.val==x)||(root.right!=null && root.right.val==x)){
            Pair p=new Pair();
            p.parent=root;
            p.height=depth+1;
            return p;
        }
            
        Pair left=getDepthAndParent(root.left,x,depth+1);
        if(left.parent==null)
            return getDepthAndParent(root.right,x,depth+1);
        return left;
        
            
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode p1=null,p2=null;
        Pair a=getDepthAndParent(root,x,0);
        Pair b=getDepthAndParent(root,y,0);
        if(a.height==b.height && a.parent!=b.parent)
            return true;
        return false;
    }
}