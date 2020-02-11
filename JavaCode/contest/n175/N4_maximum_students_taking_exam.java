package JavaCode.contest.n175;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2020/2/10
 */
public class N4_maximum_students_taking_exam {
    public int maxStudents(char[][] seats) {
        int[][] dp=new int[seats.length][1<<seats[0].length];
        for (int[] d:dp) Arrays.fill(d,-1);
        return slove(0,0,seats,dp);
    }

    private int slove(int row, int pre, char[][] seats, int[][] dp) {
        if(row==seats.length)return 0;
        if(dp[row][pre]!=-1)return dp[row][pre];
        int res=0;
        for (int i=0;i<dp[0].length;i++)
        {
            if(check(row,i,pre,seats))
            {
                res=Math.max(res,Integer.bitCount(i)+slove(row+1,i,seats,dp));
            }
        }
        return dp[row][pre]=res;
    }

    private boolean check(int row, int cur, int pre, char[][] seats) {
        for (int i=0;i<seats[row].length;i++)
        {
            if((cur&(1<<i))==0)continue;
            if(seats[row][i]=='#')return false;
            if(i>0&&seats[row][i-1]=='.'&&(cur&(1<<(i-1)))!=0)return false;
            if(i<seats[0].length-1&&seats[row][i+1]=='.'&&(cur&(1<<(i+1)))!=0)return false;
            if(row>0)
            {
                if(i>0&&seats[row-1][i-1]=='.'&&(pre&(1<<(i-1)))!=0)return false;
                if(i<seats[0].length-1&&seats[row-1][i+1]=='.'&&(pre&(1<<(i+1)))!=0)return false;
            }
        }
        return true;
    }
}
/*
给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。

学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。

学生必须坐在状况良好的座位上。

 

示例 1：



输入：seats = [["#",".","#","#",".","#"],
              [".","#","#","#","#","."],
              ["#",".","#","#",".","#"]]
输出：4
解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。
示例 2：

输入：seats = [[".","#"],
              ["#","#"],
              ["#","."],
              ["#","#"],
              [".","#"]]
输出：3
解释：让所有学生坐在可用的座位上。
示例 3：

输入：seats = [["#",".",".",".","#"],
              [".","#",".","#","."],
              [".",".","#",".","."],
              [".","#",".","#","."],
              ["#",".",".",".","#"]]
输出：10
解释：让学生坐在第 1、3 和 5 列的可用座位上。
 

提示：

seats 只包含字符 '.' 和'#'
m == seats.length
n == seats[i].length
1 <= m <= 8
1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-students-taking-exam
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
