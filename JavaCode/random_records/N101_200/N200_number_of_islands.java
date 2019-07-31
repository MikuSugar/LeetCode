package JavaCode.random_records.N101_200;

public class N200_number_of_islands {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)return 0;
        int res=0;
        boolean[][] book=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(book[i][j]||grid[i][j]=='0')continue;
                res++;
                dfs(i,j,book,grid);
            }
        }
        return res;
    }
    final static int[][] next={{-1,0},{0,-1},{0,1},{1,0}};
    private void dfs(int i, int j, boolean[][] book,char[][] grid) {
        book[i][j]=true;
        for (int[] n:next)
        {
            int ii=i+n[0];
            int jj=j+n[1];
            if(ii<0||jj<0||ii>=book.length||jj>=book[0].length||book[ii][jj]||grid[ii][jj]=='0')continue;
            dfs(ii,jj,book,grid);
        }
    }
}
/**
 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 示例 1:

 输入:
 11110
 11010
 11000
 00000

 输出: 1
 示例 2:

 输入:
 11000
 11000
 00100
 00011

 输出: 3


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-islands
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */