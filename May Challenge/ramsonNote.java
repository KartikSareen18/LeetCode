// Ransom Note
// Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

// Each letter in the magazine string can only be used once in your ransom note.

 

// Example 1:

// Input: ransomNote = "a", magazine = "b"
// Output: false
// Example 2:

// Input: ransomNote = "aa", magazine = "ab"
// Output: false
// Example 3:

// Input: ransomNote = "aa", magazine = "aab"
// Output: true
 

// Constraints:

// You may assume that both strings contain only lowercase letters.




class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer>count=new HashMap<>();
        for(int i=0;i<magazine.length();i++)
        {
            char c=magazine.charAt(i);
            count.put(c,count.getOrDefault(c,0)+1);
        }
        
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            if(count.containsKey(c)){
                int a=count.get(c);
                if(a>0)
                    count.put(c,a-1);
                else
                    return false;
            }
            else
                return false;
        }
        return true;
    }
}