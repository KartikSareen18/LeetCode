// Surrounded Regions

// Solution
// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

// Example:

// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:

// X X X X
// X X X X
// X X X X
// X O X X
// Explanation:

// Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        if(m<=2)
            return;
        int n=board[0].length;
        if(n<=2)
            return;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1 ){
                    if(board[i][j]=='O')
                        dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='A')
                    board[i][j]='O';
            }
        }
    }
    
    private void dfs(char board[][],int i,int j){
        int m=board.length;
        int n=board[0].length;
        if(i<0 || i>=m || j<0 || j>=n)
            return ;
        if(board[i][j]=='O')
        {
            board[i][j]='A';
            dfs(board,i-1,j);
            dfs(board,i+1,j);
            dfs(board,i,j+1);
            dfs(board,i,j-1);
        }
        
    }
}