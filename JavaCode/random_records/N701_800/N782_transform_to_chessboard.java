package JavaCode.random_records.N701_800;

/**
 * author:fangjie
 * time:2019/10/25
 */
public class N782_transform_to_chessboard {
    public int movesToChessboard(int[][] board) {
        final int N=board.length;
        int rowSum=0,colSum=0,rowSwap=0,colSwap=0;
        for (int i=0;i<N;i++)
        {
            for (int j=0;j<N;j++)
            {
                if((board[0][0]^board[i][0]^board[0][j]^board[i][j])==1)return -1;
            }
        }
        for (int i=0;i<N;i++)
        {
            rowSum+=board[0][i];
            colSum+=board[i][0];
            rowSwap+=board[i][0]==i%2?1:0;
            colSwap+=board[0][i]==i%2?1:0;
        }
        if (rowSum!=N/2&&rowSum!=(N+1)/2) return -1;
        if (colSum!=N/2&&colSum!=(N+1)/2) return -1;
        if(N%2==1)
        {
            if(colSwap%2==1)colSwap=N-colSwap;
            if(rowSwap%2==1)rowSwap=N-rowSwap;
        }
        else
        {
            colSwap=Math.min(colSwap,N-colSwap);
            rowSwap=Math.min(rowSwap,N-rowSwap);
        }
        return (colSwap+rowSwap)/2;

    }
}
/*
一个 N x N的 board 仅由 0 和 1 组成 。每次移动，你能任意交换两列或是两行的位置。

输出将这个矩阵变为 “棋盘” 所需的最小移动次数。“棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。如果不存在可行的变换，输出 -1。

示例:
输入: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
输出: 2
解释:
一种可行的变换方式如下，从左到右：

0110     1010     1010
0110 --> 1010 --> 0101
1001     0101     1010
1001     0101     0101

第一次移动交换了第一列和第二列。
第二次移动交换了第二行和第三行。


输入: board = [[0, 1], [1, 0]]
输出: 0
解释:
注意左上角的格值为0时也是合法的棋盘，如：

01
10

也是合法的棋盘.

输入: board = [[1, 0], [1, 0]]
输出: -1
解释:
任意的变换都不能使这个输入变为合法的棋盘。
 

提示：

board 是方阵，且行列数的范围是[2, 30]。
board[i][j] 将只包含 0或 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/transform-to-chessboard
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
