// Word Search II

// Given a 2D board and a list of words from the dictionary, find all words in the board.

// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

// Example:

// Input: 
// board = [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]
// words = ["oath","pea","eat","rain"]

// Output: ["eat","oath"]
 

// Note:

// All inputs are consist of lowercase letters a-z.
// The values of words are distinct.


// class Solution {
//     private int arr[][]={{0,1},{1,0},{-1,0},{0,-1}};
//     private HashMap<Character,ArrayList<Pair<Integer,Integer>>>map;
//     public List<String> findWords(char[][] board, String[] words) {
//         int m=board.length;
//         int n=board[0].length;
        
//         List<String> result=new ArrayList<>();
//         map=new HashMap<Character,ArrayList<Pair<Integer,Integer>>>();
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 char ch=board[i][j];
//                 if(!map.containsKey(ch)){
//                     map.put(ch,new ArrayList<Pair<Integer,Integer>>());
//                 }
//                 map.get(ch).add(new Pair<Integer,Integer>(i,j));
//             }
//         }
//         for(int i=0;i<words.length;i++){
//             ArrayList<Pair<Integer,Integer>>a=map.getOrDefault(words[i].charAt(0),new ArrayList<>());
//             for(int j=0;j<a.size();j++){
//                 if(check(board,words[i],a.get(j).getKey(),a.get(j).getValue())){
//                     result.add(words[i]);
//                     break;
//                 }
//             }
//         }
//         Collections.sort(result);
//         return result;
//     }
    
//     private boolean check(char[][] board,String s,int i,int j){
//         int m=board.length;
//         int n=board[0].length;
//         if(s.length()==0)
//             return true;
//         if(i<0 || i>=m||j<0|| j>=n || board[i][j]!=s.charAt(0) )
//             return false;
//         board[i][j]='$';
//         boolean ans=false;
//         for(int k=0;k<4;k++)
//         {
//             int nextI=i+arr[k][0];
//             int nextJ=j+arr[k][1];
//             ans=check(board,s.substring(1),nextI,nextJ);
//             if(ans)
//                 break;
//         }
//         board[i][j]=s.charAt(0);
//         return ans;
        
//     }
// }

class Solution {
    class Trie {
        Trie[] child = new Trie[26];
        boolean isWord = false;
        String word = null;
    }
    Trie root = new Trie();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words) {
            addToTrie(word);
        }
        List<String> result = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    public void dfs(char[][] board, int i, int j, Trie node, List<String> result) {
        if(i<0 || i >=board.length || j<0 || j >=board[0].length || board[i][j] == '$' || node == null || node.child[board[i][j] - 'a'] == null) return;
        char c = board[i][j];
        if(node.child[c-'a'].isWord) {
            result.add(node.child[c-'a'].word);
            node.child[c-'a'].isWord = false;
        }
        node = node.child[c-'a'];
        board[i][j] = '$';
        dfs(board, i+1, j, node, result);
        dfs(board, i-1, j, node, result);
        dfs(board, i, j+1, node, result);
        dfs(board, i, j-1, node, result);
        board[i][j] = c;
    }
    
    
    public void addToTrie(String word) {
        Trie node = root;
        for(char c: word.toCharArray()) {
            if(node.child[c-'a'] == null) {
                node.child[c-'a'] = new Trie();
            }
            node = node.child[c-'a'];
        }
        node.isWord = true;
        node.word = word;
    }
    
    
}