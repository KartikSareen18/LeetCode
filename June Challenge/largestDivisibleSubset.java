// Largest Divisible Subset

// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

// Si % Sj = 0 or Sj % Si = 0.

// If there are multiple solutions, return any subset is fine.

// Example 1:

// Input: [1,2,3]
// Output: [1,2] (of course, [1,3] will also be ok)
// Example 2:

// Input: [1,2,4,8]
// Output: [1,2,4,8]

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        // O(NlogN + N^2 + N)
        
//         int n=nums.length;
//         List<Integer>result=new ArrayList<>();
//         if(n<1)
//             return result;
//         if(n==1)
//         {
//             result.add(nums[0]);
//             return result;
//         }
//         Arrays.sort(nums);
//         int dp[]=new int[n];
//         dp[0]=1;
//         int max=-1;
//         for(int i=1;i<n;i++){
//             for(int j=0;j<i;j++){
//                 if(nums[i]%nums[j]==0 && dp[j]+1>dp[i])
//                     dp[i]=dp[j]+1;
//             }
//             if(max<dp[i])
//                 max=dp[i];
//         }
        
//         int prev=-1;
//         for(int i=n-1;i>=0;i--){
//             if(dp[i]==max){
//                 if(prev==-1 || prev%nums[i]==0)
//                 {
//                     prev=nums[i];
//                     max--;
//                     result.add(nums[i]);
//                 }
//             }
//         }
//         return result;
        
        
        // O(NlogN + N^2)
        int n=nums.length;
        List<Integer>result=new ArrayList<>();
        if(n<1)
            return result;
        if(n==1)
        {
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums);
        int []next_idx=new int[n];
        Arrays.fill(next_idx,-1);
        int []sizes=new int[n];
        Arrays.fill(sizes,1);
        int max_len=1;
        int max_idx=0;
        for(int i=n-1;i>=0;i--){
            int j=i+1;
            int max_len1=0,max_idx1=i;
            while(j<n){
                if(nums[j]%nums[i]==0 && sizes[j]>max_len1){
                    max_len1=sizes[j];
                    max_idx1=j;
                }
                j++;
            }
            if(max_idx1!=i){
                sizes[i]+=max_len1;
                next_idx[i]=max_idx1;
                if(max_len1+1>max_len){
                    max_len=max_len1+1;
                    max_idx=i;
                }
            }
        }
        int curr=max_idx;
        while(curr>=0){
            result.add(nums[curr]);
            curr=next_idx[curr];
        }
        return result;
        
        
        
    }
    
}