// Two City Scheduling

// There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

// Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

// Example 1:

// Input: [[10,20],[30,200],[400,50],[30,20]]
// Output: 110
// Explanation: 
// The first person goes to city A for a cost of 10.
// The second person goes to city A for a cost of 30.
// The third person goes to city B for a cost of 50.
// The fourth person goes to city B for a cost of 20.

// The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

// Note:

// 1 <= costs.length <= 100
// It is guaranteed that costs.length is even.
// 1 <= costs[i][0], costs[i][1] <= 1000

class Solution {
    public int twoCitySchedCost(int[][] costs) {

        int sum=0;
        int n=costs.length/2;
        Arrays.sort(costs,(a,b)-> (b[1]-b[0])-(a[1]-a[0]));
        for(int i=0;i<costs.length;i++){
            sum+=i>=costs.length/2 ? costs[i][1]:costs[i][0];
        }
        return sum;


        // int countA=0,countB=0;
        // int sum=0;
        // int n=costs.length/2;
        // //sort on the basis of difference of cost 
        // Arrays.sort(costs,(a,b)-> Math.abs(b[1]-b[0])-Math.abs(a[1]-a[0]));
        // for(int i=0;i<costs.length;i++){
        //     if(costs[i][0]<costs[i][1])
        //     {
        //         if(countA<n){
        //             sum+=costs[i][0];
        //             countA++;
        //         }
        //         else{
        //             sum+=costs[i][1];
        //             countB++;
        //         }
                
        //     }
        //     else{
        //         if(countB<n){
        //             sum+=costs[i][1];
        //             countB++;
        //         }
        //         else{
        //             sum+=costs[i][0];
        //             countA++;
        //         }
        //     }
        // }
        // return sum;
        
        
        // int sum=0;
        // int refund[]=new int[costs.length];
        // for(int i=0;i<costs.length;i++)
        // {
        //     refund[i]=costs[i][1]-costs[i][0];
        //     sum+=costs[i][0];
        // }
        // Arrays.sort(refund);
        // for(int i=0;i<costs.length/2;i++)
        //     sum+=refund[i];
        // return sum;
    }
}