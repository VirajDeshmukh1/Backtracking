//Time Complexity : O( M * N * 3 ^ L)

class Solution {
    int m; int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int i, int j, int index){
        //base
        if(index == word.length())
            return true;
        if(i<0 || i==m || j<0 || j==n || board[i][j]=='#')
            return false;
        //logic
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if(word.charAt(index)==board[i][j]){
            //action
            char temp = board[i][j];
            board[i][j] = '#'; 
            //recurse
            for(int[] dir : dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(backtrack(board, word, r, c, index + 1)){
                    return true;
                }
            }
            //backtrack
            board[i][j] = temp;
        }
        return false;
    }
}