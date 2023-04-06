package April_Extras;

public class _6thApril {
    public static void main(String[] args) {

    }
    private static int moofisland(int[][] grid) {
        int row = grid.length;
        if (row==0) return 0;
        int col = grid[0].length;
        int number=0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]==1){
                    markisland(row,col,i,j,grid);
                    number++;
                }
            }
        }
        return number;
    }

    private static void markisland(int row, int col, int i, int j, int[][] grid) {
        if (i<0 ||i>=row || j<0 || j>=col || grid[i][j]!=1)return;

        grid[i][j] = 2;

        if (i+1<row) {
            markisland(row, col, i + 1, j, grid);
        }
        if (j+1<col) {
            markisland(row, col, i, j + 1, grid);
        }
        if (i-1>=0){
            markisland(row,col,i-1,j,grid);
        }
        if (j-1>=0) {
            markisland(row, col, i, j - 1, grid);
        }
    }
}
