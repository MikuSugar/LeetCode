package JavaCode.random_records.N901_1000;

/**
 * author:fangjie
 * time:2019/9/18
 */
public class N999_available_captures_for_rook {

    public int numRookCaptures(char[][] board) {
        if(board==null||board.length==0)return 0;
        int res=0;
        int x=0,y=0;
        boolean flag=false;
        for (int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='R')
                {
                    x=i;
                    y=j;
                    flag=true;
                    break;
                }
            }
            if(flag)break;
        }
        res+=up(x,y,board);
        res+=down(x,y,board);
        res+=left(x,y,board);
        res+=right(x,y,board);
        return res;
    }

    private int right(int x, int y, char[][] board) {
        for (int i=y+1;i<board[0].length;i++)
        {
            if(board[x][i]=='p')return 1;
            else if(board[x][i]=='B')return 0;
        }
        return 0;
    }

    private int left(int x, int y, char[][] board) {
        for (int i=y-1;i>=0;i--)
        {
            if(board[x][i]=='p')return 1;
            else if(board[x][i]=='B')return 0;
        }
        return 0;
    }

    private int down(int x, int y, char[][] board) {
        for (int i=x+1;i<board.length;i++)
        {
            if(board[i][y]=='p')return 1;
            else if(board[i][y]=='B')return 0;
        }
        return 0;
    }

    private int up(int x, int y, char[][] board) {
        for (int i=x-1;i>=0;i--)
        {
            if(board[i][y]=='p')return 1;
            else if(board[i][y]=='B')return 0;
        }
        return 0;
    }
}
/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 在本例中，车能够捕获所有的卒。
 * 示例 2：
 *
 *
 *
 * 输入：[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：0
 * 解释：
 * 象阻止了车捕获任何卒。
 * 示例 3：
 *
 *
 *
 * 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 车可以捕获位置 b5，d6 和 f5 的卒。
 *  
 *
 * 提示：
 *
 * board.length == board[i].length == 8
 * board[i][j] 可以是 'R'，'.'，'B' 或 'p'
 * 只有一个格子上存在 board[i][j] == 'R'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
