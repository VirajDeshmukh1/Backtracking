//Time Complexity : O(N!)

class Solution {
    List<List<String>> result;
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n==0)
            return result;
        m = n;
        board = new int[n][n];
        backtrack(0);
        return result;
    }
    public void backtrack(int r){
        //base
        if(r==m){
            List<String> list = new ArrayList<>();
            for(int i=0;i<m;i++){
                StringBuffer sb = new StringBuffer();
                for(int j=0;j<m;j++){
                    if(board[i][j]==1){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        
        //logic
        for(int i=0;i<m;i++){
            if(isSafe(r, i)){
                //action
                board[r][i] = 1;
                //recurse
                backtrack(r + 1);
                //backtrack
                board[r][i] = 0;
            }
        }
    }
    public boolean isSafe(int r, int c){
        //column up
        for(int k=0;k<r;k++){
            if(board[k][c] == 1)
                return false;
        }
        //column up left
        int i = r-1; int j = c - 1;
        while(i>=0 && j>=0){
            if(board[i][j]==1)
                return false;
            i--; j--;
        }
        //column up right
        i = r - 1; j = c + 1;
        while(i>=0 && j < m){
            if(board[i][j] == 1)
                return false;
            i--; j++;
        }
        return true;
    }
}c j