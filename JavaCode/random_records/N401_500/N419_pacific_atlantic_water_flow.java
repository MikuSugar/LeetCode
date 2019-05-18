package JavaCode.random_records.N401_500;

import java.util.ArrayList;
import java.util.List;

public class N419_pacific_atlantic_water_flow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res=new ArrayList<>();
        if(matrix==null||matrix.length==0)return res;
        boolean[][] can1=new boolean[matrix.length][matrix[0].length];//记录能到太平洋的
        boolean[][] can2=new boolean[matrix.length][matrix[0].length];//记录能到大西洋的
        for (int i=0;i<matrix.length;i++)
        {
            dfs(can1,i,0,matrix);
            dfs(can2,i,matrix[0].length-1,matrix);
        }
        for (int i=0;i<matrix[0].length;i++)
        {
            dfs(can1,0,i,matrix);
            dfs(can2,matrix.length-1,i,matrix);
        }
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                if(can1[i][j]&&can2[i][j])
                {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }

    private static int[] r={-1,0,0,1};
    private static int[] c={0,-1,1,0};
    private void dfs(boolean[][] can, int i, int j, int[][] matrix) {
        can[i][j]=true;
        for (int k=0;k<4;k++)
        {
            int ii=i+r[k];
            int jj=j+c[k];
            if(ii<0||jj<0||ii>=matrix.length||jj>=matrix[0].length||can[ii][jj])
            {
                continue;
            }
            if(matrix[ii][jj]>=matrix[i][j])
            {
                dfs(can,ii,jj,matrix);
            }
        }
    }
}
/**
 *给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *
 *
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 *
 * 示例：
 *
 *
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
