// Single Number II

// Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

// Note:

// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// Example 1:

// Input: [2,2,3,2]
// Output: 3
// Example 2:

// Input: [0,1,0,1,0,1,99]
// Output: 99


class Solution {

    // O(NlogN + N) Sorting
//     public int singleNumber(int[] nums) {
//         int n=nums.length;
//         if(n==1)
//             return nums[0];
//         Arrays.sort(nums);
//         if(nums[0]!=nums[1])
//             return nums[0];
//         if(nums[n-1]!=nums[n-2])
//             return nums[n-1];
        
//         for(int i=1;i<n;i=i+3){
//             if(nums[i]!=nums[i-1])
//                 return nums[i-1];
//         }
//         return -1;
        
//     }
    
    // O(N) Bit Manipulation
    public int singleNumber(int[] nums) {
        
        int ones=0,twos=0;
        for(int i=0;i<nums.length;i++){
            ones=(ones^nums[i])&(~twos);
            twos=(twos^nums[i])&(~ones);
        }
        return ones;
    }
}