class Solution {
public:
    int countBattleships(vector<vector<char>>& board) {
        int count= 0;
        int m = board.size();
        int n = board[0].size();
        for(int j=0;j<n;++j){
            for(int i=0;i<m;++i){
                if(board[i][j] == '.' || (i>0 && board[i-1][j]=='X') || (j>0 && board[i][j-1] == 'X')){
                    continue;
                }
                ++count;
            }
        }
        return count;
    }
};