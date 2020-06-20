// Longest Duplicate Substring

// Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

// Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)

 

// Example 1:

// Input: "banana"
// Output: "ana"
// Example 2:

// Input: "abcd"
// Output: ""
 

// Note:

// 2 <= S.length <= 10^5
// S consists of lowercase English letters.


// using suffix array
// class Solution {
//     public String longestDupSubstring(String S) {
//         int n=S.length();
//         String arr[]=new String[n];
//         for(int i=0;i<n;i++){
//             arr[i]=S.substring(i);
//         }
//         Arrays.sort(arr);
//         int max=0;
//         String res="";
//         for(int i=0;i<n-1;i++)
//         {
//             String a="";
//             int j=0,k=0;
//             while(j<arr[i].length() && k<arr[i+1].length()){
//                 if(arr[i].charAt(j)==arr[i+1].charAt(k)){
//                     a+=arr[i].charAt(j);
//                     j++;k++;
//                 }
//                 else
//                     break;
//             }
//             if(a.length()>max)
//             {
//                 max=a.length();
//                 res=a;
//             }
//         }
            
//         return res;
        
//     }
// }

// using Rabin-Karp 's algorithm
class Solution {
 
    public String longestDupSubstring(String S) {
        int n=S.length();
        String res="";
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            String curr=rabinKarp(S,mid);
            if(curr.length()>res.length()){
                res=curr;
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return res;
    }
    
    private String rabinKarp(String s, int len) {
        Map<Long, List<Integer>> map = new HashMap<>();
        long curr=0;
        for(int i=0;i<len;i++)
            curr=curr*26 +s.charAt(i);
            
        map.put(curr, new ArrayList());
        map.get(curr).add(0);

        long RM = 1;
        for (int i = 1; i <= len - 1; i++)
            RM = (26 * RM);

        for (int i = len; i < s.length(); i++) {
            
            curr = (curr - RM * s.charAt(i - len));
            curr = (curr * 26 + s.charAt(i));
            if (map.containsKey(curr)) {
                for(int index: map.get(curr)) 
                    if(s.substring(index, index + len).equals(s.substring(i - len + 1, i + 1)))
                        return s.substring(i - len + 1, i + 1);
            } 
            map.putIfAbsent(curr, new ArrayList());
            map.get(curr).add(i - len + 1);
        }

        return "";
    }

   
}