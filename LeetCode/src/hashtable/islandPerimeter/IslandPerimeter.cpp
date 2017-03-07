class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int m = grid.size();
        if(m==0)
            return 0;
        int n = grid[0].size();
        int res=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1){
                    int edge_num = 4;
                    if(j>0 && grid[i][j-1]==1){// вС
                        --edge_num;
                    }
                    if(i>0 && grid[i-1][j]==1){// ио
                        --edge_num;
                    }
                    if(j<n-1 && grid[i][j+1]==1){//ср
                        --edge_num;
                    }
                    if(i<m-1 && grid[i+1][j]==1){//об
                        --edge_num;
                    }
                    res+=edge_num;
                }
            }
        }
        return res;
    }
};