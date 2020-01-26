package JavaCode.contest.biweekly_n16;

import java.util.List;

/**
 * author:fangjie
 * time:2019/12/30
 */
public class N4 {
    public int[] pathsWithMaxScore(List<String> board) {
        final int n=board.size(),m=board.get(0).length();
        char[][] graph=new char[n][];
        int idx=0;
        for (String s:board)graph[idx++]=s.toCharArray();
        graph[0][0]=graph[n-1][m-1]='0';

        int[][] dpSum=new int[n+1][m+1];
        int[][] dpPath=new int[n+1][m+1];

        dpPath[n-1][m-1]=1;
        for (int i=n-1;i>=0;i--)
        {
            for (int j=m-1;j>=0;j--)
            {
                if(check(i,j,graph,dpPath))
                {
                    int maxScore=Math.max(Math.max(dpSum[i+1][j],dpSum[i][j+1]),dpSum[i+1][j+1]);
                    dpSum[i][j]=maxScore+graph[i][j]-'0';
                    if(dpSum[i+1][j]==maxScore)dpPath[i][j]=(dpPath[i][j]+dpPath[i+1][j])%MOD;
                    if(dpSum[i][j+1]==maxScore)dpPath[i][j]=(dpPath[i][j]+dpPath[i][j+1])%MOD;
                    if(dpSum[i+1][j+1]==maxScore)dpPath[i][j]=(dpPath[i][j]+dpPath[i+1][j+1])%MOD;
                }
            }
        }
        return new int[]{dpSum[0][0],dpPath[0][0]};
    }

    private boolean check(int i, int j, char[][] graph, int[][] dpPath) {
        if(graph[i][j]=='X')return false;
        if(dpPath[i+1][j]!=0)return true;
        if(dpPath[i][j+1]!=0)return true;
        return dpPath[i+1][j+1]!=0;
    }

    private final static int MOD=(int) (1e9+7);
}
/*
给你一个正方形字符数组 board ，你从数组最右下方的字符 'S' 出发。

你的目标是到达数组最左上角的字符 'E' ，数组剩余的部分为数字字符 1, 2, ..., 9 或者障碍 'X'。在每一步移动中，你可以向上、向左或者左上方移动，可以移动的前提是到达的格子没有障碍。

一条路径的 「得分」 定义为：路径上所有数字的和。

请你返回一个列表，包含两个整数：第一个整数是 「得分」 的最大值，第二个整数是得到最大得分的方案数，请把结果对 10^9 + 7 取余。

如果没有任何路径可以到达终点，请返回 [0, 0] 。

 

示例 1：

输入：board = ["E23","2X2","12S"]
输出：[7,1]
示例 2：

输入：board = ["E12","1X1","21S"]
输出：[4,2]
示例 3：

输入：board = ["E11","XXX","11S"]
输出：[0,0]
 

提示：

2 <= board.length == board[i].length <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-paths-with-max-score
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
