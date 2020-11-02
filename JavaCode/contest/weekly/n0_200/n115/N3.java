package JavaCode.contest.weekly.n0_200.n115;

public class N3 {

    public static void main(String[] args) {

    }


    /**
     * 扩大3倍构造图
     * /
     * 0 0 1
     * 0 1 0
     * 1 0 0
     * \
     * 1 0 0
     * 0 1 0
     * 0 0 1
     */
    public int regionsBySlashes(String[] grid) {
        int[][] map=new int[grid.length*3][grid.length*3];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid.length;j++)
            {
                if(grid[i].charAt(j)=='/')
                {
                    map[i*3][j*3+2]=map[i*3+1][j*3+1]=map[i*3+2][j*3]=1;
                }
                else if(grid[i].charAt(j)=='\\')
                {
                    map[i*3][j*3]=map[i*3+1][j*3+1]=map[i*3+2][j*3+2]=1;
                }
            }
        }

        int res=0;
        for (int i=0;i<map.length;i++)
        {
            for (int j=0;j<map[0].length;j++)
            {
                if(map[i][j]==0)
                {
                    dfs(map,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] map, int i, int j) {
        if(i>=0&&i<map.length&&j>=0&&j<map[0].length&&map[i][j]==0)
        {
            map[i][j]=1;
            dfs(map,i-1,j);
            dfs(map,i,j-1);
            dfs(map,i,j+1);
            dfs(map,i+1,j);
        }
    }
}
/**
 * 959. 由斜杠划分区域  显示英文描述
 * 用户通过次数 5
 * 用户尝试次数 10
 * 通过次数 5
 * 提交次数 12
 * 题目难度 Medium
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 返回区域的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 *
 * 示例 2：
 *
 * 输入：
 * [
 *   " /",
 *   "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 *
 * 示例 3：
 *
 * 输入：
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 *
 * 示例 4：
 *
 * 输入：
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 *
 * 示例 5：
 *
 * 输入：
 * [
 *   "//",
 *   "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 *
 *
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] 是 '/'、'\'、或 ' '。
 */
