// Permutation Sequence

// The set [1,2,3,...,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note:

// Given n will be between 1 and 9 inclusive.
// Given k will be between 1 and n! inclusive.
// Example 1:

// Input: n = 3, k = 3
// Output: "213"
// Example 2:

// Input: n = 4, k = 9
// Output: "2314"

// class Solution {
//     public String getPermutation(int n, int k) {
//         String s="";
//         for(int i=1;i<=n;i++)
//             s+=i;
//         ArrayList<String> perm=new ArrayList<>();
//         permute(s,0,n-1,perm);
//         //Collections.sort(perm);
//         return perm.get(k-1);
//     }
    
//     private void permute(String s,int l,int r,ArrayList<String> perm){
//         if(l==r){
//             perm.add(s);
//         }
//         for(int i=l;i<=r;i++){
//             s=swap(s,l,i);
//             s=sort(s,l+1);
//             permute(s,l+1,r,perm);
//             s=swap(s,l,i);
//         }
//     }
    
//     private String sort(String s,int l){
//         int n=s.length();
//         if(l>=n)
//             return s;
//         char a[]=new char[n-l];
//         int k=0;
//         for(int i=l;i<n;i++)
//             a[k++]=s.charAt(i);
//         Arrays.sort(a);
//         return s.substring(0,l)+new String(a);
            
//     }
    
//     private String swap(String s,int i,int j){
//         StringBuilder sb=new StringBuilder(s);
//         sb.setCharAt(i,s.charAt(j));
//         sb.setCharAt(j,s.charAt(i));
//         return sb.toString();
//     }
// }

class Solution {  
    
    public String getPermutation(int n, int k) {
        List<Integer>fact=new ArrayList<>();
        List<Integer>digits=new ArrayList<>();
        for(int i=1;i<=n;i++)
            digits.add(i);
        
        fact.add(1);
        for(int i=2;i<=n;i++)
            fact.add(fact.get(i-2)*i);
        String res="";
        while(n>1){
            int block_size=fact.get(n-2);
            int index=(k-1)/block_size;
            res+=digits.get(index);
            digits.remove(index);
            k=k-(index*block_size);
            n--;
        }
        if(n==1)
            res+=digits.get(0);            
        return res;
        
        
    }
}