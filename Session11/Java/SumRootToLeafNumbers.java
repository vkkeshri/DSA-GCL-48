https://leetcode.com/problems/sum-root-to-leaf-numbers/

class Solution {
    
    int res = 0;
    void sumRootLeaf(TreeNode root, int currSum)
    {
        if(root==null)
        {
            return;
        }
        currSum *= 10; 
        currSum += root.val;
        if(root.left==null && root.right==null)
        {
            res += currSum;
            return;
        }
        
        sumRootLeaf(root.left, currSum);
        sumRootLeaf(root.right, currSum);
        
    }
    
    public int sumNumbers(TreeNode root) {
        
        if(root==null)
        {
            return 0;
        }
        sumRootLeaf(root, 0);
        return res;
        
    }
}