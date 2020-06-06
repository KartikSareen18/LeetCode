// Random Pick with Weight


// Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

// Note:

// 1 <= w.length <= 10000
// 1 <= w[i] <= 10^5
// pickIndex will be called at most 10000 times.
// Example 1:

// Input: 
// ["Solution","pickIndex"]
// [[[1]],[]]
// Output: [null,0]
// Example 2:

// Input: 
// ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
// [[[1,3]],[],[],[],[],[]]
// Output: [null,0,1,1,1,0]
// Explanation of Input Syntax:

// The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

class Solution {
    public int cum_sum[];         // cumulative sum array
    public Solution(int[] w) {
        int n=w.length;
        cum_sum=new int[n];
        cum_sum[0]=w[0];
        for(int i=1;i<n;i++){
            cum_sum[i]=cum_sum[i-1]+w[i];
        }
    }
    
    public int pickIndex() {
        int rand_weight=(int)(Math.random()*cum_sum[cum_sum.length-1]);
        return binarySearch(rand_weight+1);
    }
    
    private int binarySearch(int val){
        int left=0,right=cum_sum.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(cum_sum[mid]<val)
                left=mid+1;
            else
                right=mid;
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */