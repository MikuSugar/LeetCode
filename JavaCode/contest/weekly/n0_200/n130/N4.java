package JavaCode.contest.weekly.n0_200.n130;

public class N4 {
    public int numEnclaves(int[][] A) {

        boolean[][] book=new boolean[A.length][A[0].length];
        for (int i=0;i<A.length;i++)
        {
            dfs(i,0,book,A);
            dfs(i,A[0].length-1,book,A);
        }
        for (int j=0;j<A[0].length;j++)
        {
            dfs(0,j,book,A);
            dfs(A.length-1,j,book,A);
        }

        int res=0;
        for (int i=0;i<A.length;i++)
        {
            for (int j=0;j<A[0].length;j++)
            {
                if(!book[i][j]&&A[i][j]==1)
                    res++;
            }
        }
        return res;
    }

    private static int[] row={-1,0,0,1};
    private static int[] cul={0,-1,1,0};
    private void dfs(int i, int j, boolean[][] book, int[][] a) {
        if(book[i][j]||a[i][j]==0)return;
        book[i][j]=true;
        for (int k=0;k<4;k++)
        {
            int ii=i+row[k];
            int jj=j+cul[k];
            if(ii>=0&&ii<a.length&&jj>=0&&jj<a[0].length)
            {
                dfs(ii,jj,book,a);
            }
        }
    }

}
/**
 * 1031. 飞地的数量  显示英文描述
 * 用户通过次数 19
 * 用户尝试次数 24
 * 通过次数 19
 * 提交次数 30
 * 题目难度 Medium
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 *
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 *
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 *
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * 所有行的大小都相同
 */
