package JavaCode.top_interview_questions_hard.trees_and_graphs;

public class SurroundedArea {

    public void solve(char[][] board) {
        if(board.length==0) return;

        int[][]book=new int[board.length][board[0].length];//记录与边界0相连的0的位置

        //遍历边界
        for (int i=0;i<board[0].length;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(0,i,book,board);
            }
            if(board[board.length-1][i]=='O')
            {
                dfs(board.length-1,i,book,board);
            }
        }
        for(int i=1;i<board.length-1;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(i,0,book,board);
            }
            if(board[i][board[0].length-1]=='O')
            {
                dfs(i,board[0].length-1,book,board);
            }
        }

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='O'&&book[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }

    }

    private int[] row={-1,0,0,1};
    private int[] cul={0,-1,1,0};
    private void dfs(int i,int j,int[][] book,char[][] board)
    {
        if(book[i][j]==1) return;
        book[i][j]=1;
        for(int k=0;k<4;k++)
        {
            int ii=i+row[k];
            int jj=j+cul[k];
            if(ii>=0&&ii<board.length&&jj>=0&&jj<board[0].length&&board[ii][jj]=='O'&&book[ii][jj]==0)
            {
                dfs(ii,jj,book,board);
            }
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/138/
 * 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
