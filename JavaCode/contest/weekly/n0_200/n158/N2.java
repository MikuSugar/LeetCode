package JavaCode.contest.weekly.n0_200.n158;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author:fangjie
 * time:2019/10/13
 */
public class N2 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res=new ArrayList<>();
        int[][] queen=new int[8][2];
        for (int i=0;i<queen.length;i++)
        {
            Arrays.fill(queen[i],-1);
        }
        for (int[] q:queens)
        {
            if(q[1]==king[1])
            {
                if(q[0]<king[0])
                {
                    if(queen[0][0]==-1) help(queen,0,q);
                    else if(king[0]-queen[0][0]>king[0]-q[0]) help(queen,0,q);
                }
                else
                {
                    if(queen[1][0]==-1) help(queen,1,q);
                    else if(queen[1][0]-king[0]>q[0]-king[0])help(queen,1,q);
                }
            }
            else if(q[0]==king[0])
            {
                if(q[1]<king[1])
                {
                    if(queen[2][0]==-1)help(queen,2,q);
                    else if(Math.abs(king[1]-q[1])<Math.abs(queen[2][1]-king[1])) help(queen,2,q);

                }
                else
                {
                    if(queen[3][0]==-1)help(queen,3,q);
                    else if(Math.abs(king[1]-q[1])<Math.abs(queen[3][1]-king[1])) help(queen,3,q);
                }
            }
            else if(q[0]+q[1]==king[0]+king[1])
            {
                if(q[1]<king[1])
                {
                    if(queen[4][0]==-1)help(queen,4,q);
                    else if(check(king,q,queen[4])) help(queen,4,q);
                }
                else
                {
                    if(queen[5][0]==-1)help(queen,5,q);
                    else if(check(king,q,queen[5])) help(queen,5,q);
                }
            }
            else if(q[0]-q[1]==king[0]-king[1])
            {
                if(q[1]<king[1])
                {
                    if(queen[6][0]==-1)help(queen,6,q);
                    else if(check(king,q,queen[6])) help(queen,6,q);
                }
                else
                {
                    if(queen[7][0]==-1)help(queen,7,q);
                    else if(check(king,q,queen[7])) help(queen,7,q);
                }
            }
        }
        for (int[] q:queen)
        {
            if(q[0]!=-1)
            {
                List<Integer> ress=new ArrayList<>(2);
                ress.add(q[0]);ress.add(q[1]);
                res.add(ress);
            }
        }
        return res;
    }
    private void  help(int[][] queen,int idx,int q[])
    {
        queen[idx][0]=q[0];
        queen[idx][1]=q[1];
    }

    private boolean check(int[] king,int[] q,int [] q2)
    {
        int a=(king[0]-q[0])*(king[0]-q[0])+(king[1]-q[1])*(king[1]-q[1]);
        int b=(king[0]-q2[0])*(king[0]-q2[0])+(king[1]-q2[1])*(king[1]-q2[1]);
        return a<b;
    }
}
/**
 *在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 *
 * 「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。
 *
 * 「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。
 *
 * 请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * 输出：[[0,1],[1,0],[3,3]]
 * 解释：
 * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
 * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
 * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
 * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
 * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
 * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
 * 示例 2：
 *
 *
 *
 * 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * 输出：[[2,2],[3,4],[4,4]]
 * 示例 3：
 *
 *
 *
 * 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 *
 *
 * 提示：
 *
 * 1 <= queens.length <= 63
 * queens[0].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * 一个棋盘格上最多只能放置一枚棋子。
 */
