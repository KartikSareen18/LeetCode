// Perfect Squares

// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// Example 1:

// Input: n = 12
// Output: 3 
// Explanation: 12 = 4 + 4 + 4.
// Example 2:

// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.

class Solution {
    public int numSquares(int n) {
 
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            int min_val=i;
            int j=1,sq=1;
            while(sq<=i){
                min_val=Math.min(min_val, dp[i-sq] + 1);
                j++;
                sq=j*j;
            }
            dp[i]=min_val;
        }

        return dp[n];
    }
}