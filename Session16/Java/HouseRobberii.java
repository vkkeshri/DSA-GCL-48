https://leetcode.com/problems/house-robber-ii/

class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // not including last house
        for(int i=2; i<n-1; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        
        int op1 = dp[n-2];
        
        // not taking first house
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        int op2 = dp[n-1];
        
        return Math.max(op1, op2);
    }
}