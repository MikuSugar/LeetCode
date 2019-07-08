package JavaCode.random_records.N801_900;

public class N840_magic_squares_in_grid {
    public int numMagicSquaresInside(int[][] grid) {
        int res=0;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                res+=check(i,j,grid);
            }
        }
        return res;
    }

    private int check(int i, int j, int[][] grid) {
        if(i+2>=grid.length||j+2>=grid[0].length)return 0;
        if(!checkNum(i,j,grid))return 0;
        int sum=grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        if(sum!=grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j])return 0;
        for (int k=i;k<i+3;k++)
        {
            if(sum!=grid[k][j]+grid[k][j+1]+grid[k][j+2])return 0;
        }
        for (int k=j;k<j+3;k++)
        {
            if(sum!=grid[i][k]+grid[i+1][k]+grid[i+2][k])return 0;
        }
        return 1;
    }

    private boolean checkNum(int ii, int jj, int[][] grid) {
        boolean[] book=new boolean[10];
        for (int i=ii;i<ii+3;i++)
        {
            for (int j=jj;j<jj+3;j++)
            {
                if(grid[i][j]<=0||grid[i][j]>9)return false;
                if(book[grid[i][j]])return false;
                book[grid[i][j]]=true;
            }
        }
        return true;
    }
}
/**
 *3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 *  
 *
 * 示例：
 *
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 *
 * 而这一个不是：
 * 384
 * 519
 * 762
 *
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-squares-in-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
